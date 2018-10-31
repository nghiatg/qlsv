/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.model.EducationSystem;
import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EducationSystemRepository;
import com.example.demo.repository.TheClassRepository;

/**
 * @author User
 *
 */
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private TheClassRepository classRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EducationSystemRepository educationSystemRepository;

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

	@Override
	public boolean addOrUpdateClass(String classId, String className, String courseId, String departmentId, String systemId) {
		Course course = courseRepository.findByCourseId(courseId).get(0);
		System.out.println(course.getCourseName());
		EducationSystem eduSystem = educationSystemRepository.findBySystemId(systemId).get(0);
		System.out.println(eduSystem.getSystemName());
		Department department = departmentRepository.findByDepartmentId(departmentId).get(0);
		System.out.println(department.getDepartmentName());
		TheClass newClass = new TheClass(classId, className, course, department, eduSystem);
		try {
			classRepository.save(newClass);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteClass(String classId) {
		TheClass deletedClass = classRepository.findByClassId(classId).get(0);
		try {
			classRepository.delete(deletedClass);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TheClass> getClassByName(String className) {
		// TODO Auto-generated method stub
		return classRepository.findByClassNameContaining(className);
	}


	
	
}
