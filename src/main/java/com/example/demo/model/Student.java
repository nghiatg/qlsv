/**
 * 
 */
package com.example.demo.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "SinhVien")
public class Student {
	@Id
	@Column(name = "MaSV")
	private String studentId;

	@Column(name = "TenSV")
	private String studentName;

	@Column(name = "GioiTinh")
	private boolean studentGender;

	@Column(name = "NgaySinh")
	private String dateOfBirth;

	@Column(name = "QueQuan")
	private String placeOfBirth;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaLop")
	private TheClass theClass;

	@ManyToMany(mappedBy = "allStudents")
	private Set<Subject> allSubjects;

	/**
	 * 
	 */
	public Student() {
		super();
	}

	/**
	 * @param studentName
	 * @param studentGender
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param theClass
	 * @param allSubjects
	 */
	public Student(String studentName, boolean studentGender, String dateOfBirth, String placeOfBirth,
			TheClass theClass) {
		super();
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.theClass = theClass;
	}

	/**
	 * @param studentId
	 * @param studentName
	 * @param studentGender
	 * @param dateOfBirth
	 * @param placeOfBirth
	 * @param theClass
	 * @param allSubjects
	 */
	public Student(String studentId, String studentName, boolean studentGender, String dateOfBirth, String placeOfBirth,
			TheClass theClass) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentGender = studentGender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.theClass = theClass;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentGender
	 */
	public boolean isStudentGender() {
		return studentGender;
	}

	/**
	 * @param studentGender the studentGender to set
	 */
	public void setStudentGender(boolean studentGender) {
		this.studentGender = studentGender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * @return the theClass
	 */
	public TheClass getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(TheClass theClass) {
		this.theClass = theClass;
	}

	/**
	 * @return the allSubjects
	 */
	public Set<Subject> getAllSubjects() {
		return allSubjects;
	}

	/**
	 * @param allSubjects the allSubjects to set
	 */
	public void setAllSubjects(Set<Subject> allSubjects) {
		this.allSubjects = allSubjects;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Student that = (Student) o;
		return studentId.equals(that.getStudentId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

}
