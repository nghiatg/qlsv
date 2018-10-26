package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(Score.class)
@Table(name="Diem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Score implements Serializable {
	   @Id
	   @Column(name="MaSV")
       private String studentId;
	   @Id
	   @Column(name="MaMH")
       private String subjectId;
	   @Column(name="HocKi")
       private int semester;
	   @Column(name="DiemLan1")
       private int firstPoint;
	   @Column(name="DiemLan2")
       private int secondPoint;
}
