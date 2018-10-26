/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TheClassRepository;

/**
 * @author User
 *
 */
@RestController
public class ClassController {
	@Autowired
	TheClassRepository classRepo;
	@Autowired
	StudentRepository studentRepo;
	
	@RequestMapping("/")
	public String getAllClass() {
		TheClass c = classRepo.findByClassId("KT1").get(0);
		System.out.println(c.getClassName());
		Student s = new Student("347845","a", true, "10-10-1990", "hanoi", c);
		System.out.println(s.getStudentId());
		studentRepo.save(s);
		
		StringBuilder sb = new StringBuilder();
//		for(TheClass c : classRepo.findAll()) {
//			sb.append(c.getClassName()).append("\t");
//		}
		return sb.toString();
	}
}
