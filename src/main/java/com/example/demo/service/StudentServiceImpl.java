/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.repository.StudentRepository;

/**
 * @author User
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassServiceImpl classServiceImpl;

	/* (non-Javadoc)
	 * @see com.example.demo.service.StudentService#getAllStudents()
	 */
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.StudentService#addStudent(java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addOrUpdateStudent(String studentId, String studentName, boolean studentGender, String dateOfBirth,
			String placeOfBirth, String classId) {
		List<TheClass> allClasses = classServiceImpl.findClassById(classId);
		TheClass theClass = allClasses.get(0);
		Student student = new Student(studentId, studentName, studentGender, dateOfBirth, placeOfBirth, theClass);
		try{
			studentRepository.save(student);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
