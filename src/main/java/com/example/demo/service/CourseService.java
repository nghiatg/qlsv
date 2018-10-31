/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.Student;

/**
 * @author User
 *
 */
public interface CourseService {
	public List<Course> getAllCourses();
	public boolean addOrUpdateCourse(String courseId, String courseName);
	public boolean deleteCourse(String courseId);
	public List<Course> getCourseByName(String courseName);

}
