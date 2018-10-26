/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

/**
 * @author User
 *
 */
public interface StudentService {
	public List<Student> getAllStudents();

	public boolean addOrUpdateStudent(String studentId, String studentName, boolean studentGender, String dateOfBirth,
			String placeOfBirth, String classId);
	

}
