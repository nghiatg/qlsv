package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Lop")
public class TheClass {
   @Id
   @Column(name="MaLop")
   private String classId;
   @Column(name="TenLop")
   private String className;
   
   @ManyToOne
   @JoinColumn(name="MaKhoa")
   private Department department;
   
   @ManyToOne
   @JoinColumn(name="MaHeDt")
   private System system;
   
   
   @ManyToOne
   @JoinColumn(name="MaKhoaHoc")
   private Course course; 
   
   @OneToMany(mappedBy="classStudent",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
   private List<Student>listStudent;
   
   public void addStudent(Student student) {
	   if(listStudent==null) {
		   listStudent=new ArrayList<>();
	   }
	   listStudent.add(student);
	   student.setClassStudent(this);
   }
}
