package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SinhVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	 @Id
	 @Column(name="MaSV")
     private String maSv;
	 @Column(name="tenSV")
     private String tenSv;
	 @Column(name="GioiTinh")
     private int sex;
	 @Column(name="NgaySinh")
     private String dateOfBirth;
	 @Column(name="QueQuan")
     private String placeOfBirth;
	 
	 @ManyToOne
	 @JoinColumn(name="MaLop")
     private TheClass classStudent;
	 
	 @ManyToMany(mappedBy="listStudent")
	 private List<Subject> listSubject;
	 
}
