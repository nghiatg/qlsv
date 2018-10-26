/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

/**
 * @author User
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	/* (non-Javadoc)
	 * @see com.example.demo.service.CourseService#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	

}
