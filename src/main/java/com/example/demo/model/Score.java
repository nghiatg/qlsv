/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "Diem")
public class Score {

	@EmbeddedId
	private ScoreCompositeKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("studentId")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("subjectId")
	private Subject subject;

	@Column(name = "HocKy")
	private int semester;

	@Column(name = "DiemLan1")
	private int firstScore;

	@Column(name = "DiemLan2")
	private int secondScore;

	/**
	 * 
	 */
	public Score() {
		super();
	}

	/**
	 * @param id
	 * @param student
	 * @param subject
	 * @param semester
	 * @param firstScore
	 * @param secondScore
	 */
	public Score(ScoreCompositeKey id, Student student, Subject subject, int semester, int firstScore,
			int secondScore) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.semester = semester;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	/**
	 * @return the id
	 */
	public ScoreCompositeKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ScoreCompositeKey id) {
		this.id = id;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	/**
	 * @return the firstScore
	 */
	public int getFirstScore() {
		return firstScore;
	}

	/**
	 * @param firstScore the firstScore to set
	 */
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	/**
	 * @return the secondScore
	 */
	public int getSecondScore() {
		return secondScore;
	}

	/**
	 * @param secondScore the secondScore to set
	 */
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

}
