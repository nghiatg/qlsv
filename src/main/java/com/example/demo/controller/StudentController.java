/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.service.ClassService;
import com.example.demo.service.StudentService;

/**
 * @author User
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentServiceImpl;
	@Autowired
	private ClassService classServiceImpl;

	/**
	 * description: 
	 * @param
	 * @return
	 * @param studentId
	 * @param studentName
	 * @param studentGender
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param classId
	 * @return
	 * 11:42:10 AM
	 * String
	 * Oct 29, 2018
	 */
	@PostMapping("/addOrUpdateStudent")
	public String addStudent(@RequestParam String studentId, @RequestParam String studentName,
			@RequestParam boolean studentGender, @RequestParam String dateOfBirth, @RequestParam String placeOfBirth,
			@RequestParam String classId) {
		boolean canAddStudent = studentServiceImpl.addOrUpdateStudent(studentId, studentName, studentGender,
				dateOfBirth, placeOfBirth, classId);
		if (canAddStudent == true) {
			return "success";
		}
		return "add failed";
	}

	/**
	 * description: 
	 * @param
	 * @return
	 * @param studentId
	 * @return
	 * 11:42:14 AM
	 * String
	 * Oct 29, 2018
	 */
	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam String studentId) {
		boolean canDeleteStudent = studentServiceImpl.deleteStudent(studentId);
		if (canDeleteStudent == true) {
			return "successfully";
		}
		return "failed";
	}

//	@GetMapping(value = "/student", produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
//			MediaType.APPLICATION_JSON_VALUE })
	/**
	 * description: 
	 * @param
	 * @return
	 * @return
	 * 11:42:18 AM
	 * ModelAndView
	 * Oct 29, 2018
	 */
	@GetMapping(value = "/student")
	public ModelAndView getAllStudent() {
		ModelAndView modelView = new ModelAndView("student");
		List<Student> listStudent = studentServiceImpl.getAllStudents();
		List<TheClass> listClass = classServiceImpl.getAllClass();
		modelView.addObject("listStudent", listStudent);
		modelView.addObject("listClass", listClass);
		return modelView;
	}
	/**
	 * description: 
	 * @param
	 * @return
	 * @param keySearch
	 * @return
	 * 11:42:28 AM
	 * String
	 * Oct 29, 2018
	 */
	@PostMapping(value="/searchStudent")
	public String serachStudent(@RequestParam String keySearch) {
		List<Student> listStudent=studentServiceImpl.getStudentsByName(keySearch);
		StringBuilder sb = new StringBuilder();
		for(Student s : listStudent) {
			sb.append(s.getStudentName()).append("_");
		}
		return sb.toString();
	}

}
