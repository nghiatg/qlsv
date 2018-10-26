/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TheClass;
import com.example.demo.repository.TheClassRepository;

/**
 * @author User
 *
 */
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private TheClassRepository classRepository;

	/* (non-Javadoc)
	 * @see com.example.demo.service.ClassService#getAllClass()
	 */
	@Override
	public List<TheClass> getAllClass() {
		return classRepository.findAll();
	}
	
	public List<TheClass> findClassById(String classId){
		return classRepository.findByClassId(classId);
	}
	
}
