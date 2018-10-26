/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentServiceImpl;

/**
 * @author User
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/addStudent")
	public String addStudent(@RequestParam String studentId, @RequestParam String studentName,
			@RequestParam boolean studentGender, @RequestParam String dateOfBirth, @RequestParam String placeOfBirth,
			@RequestParam String classId) {
		boolean canAddStudent = studentServiceImpl.addOrUpdateStudent(studentId, studentName, studentGender, dateOfBirth,
				placeOfBirth, classId);
		if (canAddStudent == true) {
			return "add successfully";
		}
		return "add failed";
	}
	
	@PostMapping("/fixStudent")
	public String fixStudent(@RequestParam String studentId, @RequestParam String studentName,
			@RequestParam boolean studentGender, @RequestParam String dateOfBirth, @RequestParam String placeOfBirth,
			@RequestParam String classId) {
		boolean canAddStudent = studentServiceImpl.addOrUpdateStudent(studentId, studentName, studentGender, dateOfBirth,
				placeOfBirth, classId);
		if (canAddStudent == true) {
			return "add successfully";
		}
		return "add failed";
	}
	
	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam String studentId, @RequestParam String studentName,
			@RequestParam boolean studentGender, @RequestParam String dateOfBirth, @RequestParam String placeOfBirth,
			@RequestParam String classId) {
		boolean canAddStudent = studentServiceImpl.addOrUpdateStudent(studentId, studentName, studentGender, dateOfBirth,
				placeOfBirth, classId);
		if (canAddStudent == true) {
			return "add successfully";
		}
		return "add failed";
	}

}
