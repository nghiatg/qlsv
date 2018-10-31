package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EducationSystem;
import com.example.demo.repository.EducationSystemRepository;
@Service
public class EducationServiceImpl implements EducationSystemService {
    @Autowired
    private EducationSystemRepository educationRepository;
	@Override
	public List<EducationSystem> getAllEducationSystem() {
		// TODO Auto-generated method stub
		return educationRepository.findAll();
	}

}
