package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Khoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
     @Id
     @Column(name="MaKhoa")
     private String departmentId;
     @Column(name="TenKhoa")
     private String departmentName;
     @Column(name="DiaChi")
     private String departmentPlace;
     @Column(name="DienThoai")
     private String departmentPhone;
     @OneToMany(mappedBy="department",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
     private List<TheClass> listClass;
     //add Class to Department
     public void addClass(TheClass theClass) {
     	if(listClass==null) listClass=new ArrayList<>();
     	listClass.add(theClass);
     }
}
