/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.model.EducationSystem;
import com.example.demo.model.Student;
import com.example.demo.model.TheClass;
import com.example.demo.service.ClassService;
import com.example.demo.service.CourseService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EducationSystemService;

/**
 * @author User
 *
 */
@RestController
public class ClassController {
	private ClassService classServiceImpl; 
	private CourseService courseServiceImpl;
	private DepartmentService departmentServiceImpl;
	private EducationSystemService educationServiceImpl;
	
    @Autowired
	public ClassController(ClassService classServiceImpl, CourseService courseServiceImpl,
			DepartmentService departmentServiceImpl, EducationSystemService educationServiceImpl) {
		this.classServiceImpl = classServiceImpl;
		this.courseServiceImpl = courseServiceImpl;
		this.departmentServiceImpl = departmentServiceImpl;
		this.educationServiceImpl = educationServiceImpl;
	}
	@PostMapping("/addOrUpdateClass")
	public String addOrUpdateClass(@RequestParam String classId, @RequestParam String className,
			@RequestParam String courseId, @RequestParam String departmentId, @RequestParam String systemId) {
		boolean canAddOrUpdate = classServiceImpl.addOrUpdateClass(classId, className, courseId, departmentId, systemId);
		if(canAddOrUpdate) {
			return "success";
		}
		return "failed";
	}
	
	@PostMapping("/deleteClass")
	public String deleteClass(@RequestParam String classId) {
		boolean canDelete = classServiceImpl.deleteClass(classId);
		if(canDelete) {
			return "success";
		}
		return "failed";
	}
	@GetMapping(value="/class")
	public ModelAndView gotoPage() {
		ModelAndView modelView=new ModelAndView("class");
		List<TheClass> listClass=classServiceImpl.getAllClass();
		List<Department> listDepartment=departmentServiceImpl.getAllDepartment();
		List<Course> listCourse=courseServiceImpl.getAllCourses();
		List<EducationSystem> listEducation=educationServiceImpl.getAllEducationSystem();
		modelView.addObject("listClass", listClass);
		modelView.addObject("listCourse", listCourse);
		modelView.addObject("listEdu", listEducation);
		modelView.addObject("listDepartment", listDepartment);
		return modelView;
	}
	@PostMapping(value="/searchClass")
	public String serachStudent(@RequestParam String keySearch) {
		List<TheClass> listClass=classServiceImpl.getClassByName(keySearch);
		StringBuilder sb = new StringBuilder();
		for(TheClass s : listClass) {
			sb.append(s.getClassName()).append("_");
		}
		return sb.toString();
	}
}
