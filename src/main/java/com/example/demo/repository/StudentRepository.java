/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

/**
 * @author User
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	public List<Student> findByStudentId(String studentId);
	public List<Student> findByStudentNameContaining(String studentName);
}
