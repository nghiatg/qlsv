/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.model.TheClass;

/**
 * @author User
 *
 */
public interface ClassService {
	public List<TheClass> getAllClass();
	public boolean addOrUpdateClass(String classId, String className, String courseId, String departmentId, String systemId);
	public boolean deleteClass(String classId);
	public List<TheClass> getClassByName(String studentName);

}
