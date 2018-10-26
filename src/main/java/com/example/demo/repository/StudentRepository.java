/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

/**
 * @author User
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
