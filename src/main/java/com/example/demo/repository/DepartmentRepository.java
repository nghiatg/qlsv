/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

/**
 * @author User
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{
	public List<Department> findByDepartmentId(String departmentId);

}
