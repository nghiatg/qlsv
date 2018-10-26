/**
 * 
 */
package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "KhoaHoc")
public class Course {
	@Id
	@Column(name = "MaKhoaHoc")
	private String courseId;

	@Column(name = "TenKhoaHoc")
	private String courseName;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TheClass> classes;

	/**
	 * 
	 */
	public Course() {
		super();
	}

	/**
	 * @param courseId
	 * @param courseName
	 * @param classes
	 */
	public Course(String courseId, String courseName, List<TheClass> classes) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.classes = classes;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the classes
	 */
	public List<TheClass> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(List<TheClass> classes) {
		this.classes = classes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Course that = (Course) o;
		return courseId.equals(that.getCourseId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}
}
