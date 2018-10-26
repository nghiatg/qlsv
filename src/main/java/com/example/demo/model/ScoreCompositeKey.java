/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author User
 *
 */
@Embeddable
public class ScoreCompositeKey implements Serializable {
	@Column(name = "MaSV")
	private String studentId;

	@Column(name = "MaMH")
	private String subjectId;

	/**
	 * @param studentId
	 * @param subjectId
	 */
	public ScoreCompositeKey(String studentId, String subjectId) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;
		
		ScoreCompositeKey compositeKey = (ScoreCompositeKey)o;
		return studentId.equals(compositeKey.getStudentId()) && subjectId.equals(compositeKey.getSubjectId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(studentId,subjectId);
	}

}
