/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;

/**
 * @author User
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.demo.service.CourseService#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public boolean addOrUpdateCourse(String courseId, String courseName) {
		Course newCourse = new Course(courseId,courseName);
		try{
			courseRepository.save(newCourse);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(String courseId) {
		try {
			List<Course> matchedCourses = courseRepository.findByCourseId(courseId);
			Course deletedCourse = matchedCourses.get(0);
			courseRepository.delete(deletedCourse);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Course> getCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseNameContaining(courseName);
	}
	

}
