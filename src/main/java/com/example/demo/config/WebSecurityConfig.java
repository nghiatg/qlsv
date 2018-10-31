package com.example.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 @Autowired
	 private DataSource dataSource;
	 
	 private final String USERS_QUERY = "select email,password,active  from users where email=?";
	 private final String ROLES_QUERY = "select u.email, r.roleName from users u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication()
	   .usersByUsernameQuery(USERS_QUERY)
	   .authoritiesByUsernameQuery(ROLES_QUERY)
	   .dataSource(dataSource)
	   .passwordEncoder(bCryptPasswordEncoder);
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests()
	   .antMatchers("/").permitAll()
	   .antMatchers("/login").permitAll()
	   .antMatchers("/signup").permitAll()
	   .antMatchers("/home/**").hasAuthority("ADMIN").anyRequest()
	   .authenticated().and().csrf().disable()
	   .formLogin().loginPage("/login").failureUrl("/login?error=true")
	   .defaultSuccessUrl("/student")
	   .usernameParameter("email")
	   .passwordParameter("password")
	   .and().logout()
	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	   .logoutSuccessUrl("/")
	   .and().exceptionHandling().accessDeniedPage("/access_denied");
	   http.authorizeRequests().and() 
	   //remember me
       .rememberMe().tokenRepository(this.persistentTokenRepository()) 
       .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	 }
	 
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	     JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	     db.setDataSource(dataSource);
	     return db;
	 }

}
