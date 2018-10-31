/**
 * 
 */
package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "Lop")
public class TheClass {
	@Id
	@Column(name = "MaLop")
	private String classId;

	@Column(name = "TenLop")
	private String className;

	@OneToMany(mappedBy = "theClass",cascade=CascadeType.ALL)
	private List<Student> allStudents;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhoaHoc")
	private Course course;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhoa")
	private Department department;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaHeDT")
	private EducationSystem eduSystem;

	/**
	 * 
	 */
	public TheClass() {
		super();
	}

	/**
	 * @param classId
	 * @param className
	 * @param allStudents
	 * @param course
	 * @param department
	 * @param eduSystem
	 */
	public TheClass(String classId, String className, List<Student> allStudents, Course course, Department department,
			EducationSystem eduSystem) {
		super();
		this.classId = classId;
		this.className = className;
		this.allStudents = allStudents;
		this.course = course;
		this.department = department;
		this.eduSystem = eduSystem;
	}

	public TheClass(String classId, String className, Course course, Department department, EducationSystem eduSystem) {
		super();
		this.classId = classId;
		this.className = className;
		this.course = course;
		this.department = department;
		this.eduSystem = eduSystem;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the allStudents
	 */
	public List<Student> getAllStudents() {
		return allStudents;
	}

	/**
	 * @param allStudents the allStudents to set
	 */
	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the eduSystem
	 */
	public EducationSystem getEduSystem() {
		return eduSystem;
	}

	/**
	 * @param eduSystem the eduSystem to set
	 */
	public void setEduSystem(EducationSystem eduSystem) {
		this.eduSystem = eduSystem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		TheClass that = (TheClass) o;
		return classId.equals(that.getClassId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(classId);
	}

}
