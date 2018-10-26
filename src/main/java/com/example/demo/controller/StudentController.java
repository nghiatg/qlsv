package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.respository.TheClassRepository;
import com.example.demo.service.StudentServiceImpl;
import com.example.demo.service.TheClassService;
import com.example.demo.service.TheClassServiceImpl;

@RestController
public class StudentController {
    private StudentServiceImpl studentService;
    private TheClassServiceImpl theClassService;
    @Autowired
	public StudentController(StudentServiceImpl studentService,TheClassServiceImpl theClassService) {
		this.studentService = studentService;
		this.theClassService=theClassService;
	}
    @PostMapping(value="/student", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Student addStudent(@RequestBody Student student,@RequestParam("maLop") String maLop) {
    	TheClass theClass=theClassService.getClassById(maLop);
    	theClass.addStudent(student);
    	theClassService.save(theClass);
    	return student;
    }
}
