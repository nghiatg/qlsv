package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
