/**
 * 
 */
package com.example.demo.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "MonHoc")
public class Subject {
	@Id
	@Column(name = "MaMH")
	private String subjectId;

	@Column(name = "TenMH")
	private String subjectName;

	@Column(name = "SoTrinh")
	private int number;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Diem", joinColumns = @JoinColumn(name = "MaMH", referencedColumnName = "MaMH"), 
					inverseJoinColumns = @JoinColumn(name = "MaSV", referencedColumnName = "MaSV"))
	private Set<Student> allStudents;

	/**
	 * 
	 */
	public Subject() {
		super();
	}

	/**
	 * @param subjectId
	 * @param subjectName
	 * @param number
	 * @param allStudents
	 */
	public Subject(String subjectId, String subjectName, int number, Set<Student> allStudents) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.number = number;
		this.allStudents = allStudents;
	}

	/**
	 * @return the subjectId
	 */
	public String getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the allStudents
	 */
	public Set<Student> getAllStudents() {
		return allStudents;
	}

	/**
	 * @param allStudents the allStudents to set
	 */
	public void setAllStudents(Set<Student> allStudents) {
		this.allStudents = allStudents;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Subject that = (Subject) o;
		return subjectId.equals(that.getSubjectId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(subjectId);
	}

}
