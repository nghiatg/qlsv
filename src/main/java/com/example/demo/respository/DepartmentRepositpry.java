package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;
@Repository
public interface DepartmentRepositpry extends JpaRepository<Department, Long> {

}
