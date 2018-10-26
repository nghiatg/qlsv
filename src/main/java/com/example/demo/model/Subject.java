package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MonHoc")
public class Subject {
    @Id
    @Column(name="MaMH")
    private String subjectId;
    @Column(name="TenMH")
    private String subjectName;
    @Column(name="Sotring")
    private int number;
   
    @ManyToMany(cascade= {
                  CascadeType.PERSIST,
                  CascadeType.MERGE,
                  CascadeType.REFRESH
    })@JoinTable(name="Diem",
                 joinColumns=@JoinColumn(name="MaMH"),
                 inverseJoinColumns=@JoinColumn(name="MaSV")
    )
    private List<Student> listStudent;
}
