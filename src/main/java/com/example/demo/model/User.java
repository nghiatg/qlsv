package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 @Column(name = "email")
	 private String email;
	 @Column(name = "firstname")
	 private String firstname; 
	 @Column(name = "lastname")
	 private String lastname;
	 @Column(name = "active")
	 private int active;
	 public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

	@Column(name = "password")
	 private String password;
	 @ManyToMany(cascade=CascadeType.ALL)
	       @JoinTable(name="user_role",
	       joinColumns=@JoinColumn(name="user_id"), 
	       inverseJoinColumns=@JoinColumn(name="role_id"))
	 private Set<Role> roles;
	 public int getId() {
	  return id;
	 }
	 public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String firstname, String lastname, String password) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public void setId(int id) {
	  this.id = id;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public String getFirstname() {
	  return firstname;
	 }

	 public void setFirstname(String firstname) {
	  this.firstname = firstname;
	 }

	 public String getLastname() {
	  return lastname;
	 }

	 public void setLastname(String lastname) {
	  this.lastname = lastname;
	 }

	 public String getPassword() {
	  return password;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }
	 public Set<Role> getRoles() {
	  return roles;
	 }

	 public void setRoles(Set<Role> roles) {
	  this.roles = roles;
	 }
}
