package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value="select *from users where email=:email",nativeQuery=true)
	User findByEmail(@Param("email") String email);
}
