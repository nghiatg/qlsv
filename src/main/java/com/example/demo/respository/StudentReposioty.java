package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentReposioty extends JpaRepository<Student, Long> {
	@Query(value="insert into SinhVien(MaSV,TenSV,GioiTinh,NgaySinh,QueQuan) values(:masv,:ten,:sex,:date,:place)",nativeQuery=true)
	void addStudent(@Param("masv") String masv,@Param("ten") String tenSv,@Param("sex") int sex,@Param("date") String date,@Param("place") String place);

}
