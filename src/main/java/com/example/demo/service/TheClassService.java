package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TheClass;
import com.example.demo.respository.TheClassRepository;
@Service
public class TheClassService implements TheClassServiceImpl {
	private TheClassRepository theClassRepository;
	@Autowired
    public TheClassService(TheClassRepository theClassRepository) {
		super();
		this.theClassRepository = theClassRepository;
	}
	@Override
	public TheClass getClassById(String classId) {
		// TODO Auto-generated method stub
		return theClassRepository.getClassByID(classId);
	}
	@Override
	public void save(TheClass cTheClass) {
		// TODO Auto-generated method stub
		theClassRepository.save(cTheClass);
		
	}
     
}
