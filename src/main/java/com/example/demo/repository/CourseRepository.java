/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;

/**
 * @author User
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
