package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseServiceImpl;
	
	@PostMapping("/addOrUpdateCourse")
	public String addOrUpdateCourse(@RequestParam String courseId, @RequestParam String courseName) {
		boolean canAddOrUpdate = courseServiceImpl.addOrUpdateCourse(courseId, courseName);
		if(canAddOrUpdate) {
			return "success";
		}
		return "failed";
	}
	
	@PostMapping("/deleteCourse")
	public String deleteCourse(@RequestParam String courseId) {
		boolean canDelete = courseServiceImpl.deleteCourse(courseId);
		if(canDelete) {
			return "success";
		}
		return "failed";
	}
	@GetMapping(value="/course")
	public ModelAndView goToPage() {
		ModelAndView modelView=new ModelAndView("course");
		List<Course> listCourse=courseServiceImpl.getAllCourses();
		modelView.addObject("listCourse", listCourse);
		return modelView;
	}
	@PostMapping(value="/searchCourse")
	public String searchCourse(@RequestParam String keySearch) {
		List<Course> listCourse=courseServiceImpl.getCourseByName(keySearch);
		StringBuilder sb = new StringBuilder();
		for(Course s : listCourse) {
			sb.append(s.getCourseName()).append("_");
		}
		return sb.toString();
	}

}
