package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.respository.StudentReposioty;
@Service
public class StudentService implements StudentServiceImpl {
	@PersistenceContext
	private EntityManager entityManager;
    private StudentReposioty studentReposioty;
    @Autowired
	public StudentService(StudentReposioty studentReposioty) {
		this.studentReposioty = studentReposioty;
	}
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		student.setMaSv(student.getMaSv());
		studentReposioty.addStudent(student.getMaSv(), student.getTenSv(), student.getSex(), student.getDateOfBirth(), student.getPlaceOfBirth());
		return student;
	}
     
}
