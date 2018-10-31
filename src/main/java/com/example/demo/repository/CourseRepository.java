/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.Student;

/**
 * @author User
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
	public List<Course> findByCourseId(String courseId);
	public List<Course> findByCourseNameContaining(String studentName);
}
