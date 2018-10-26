package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TheClass;
@Repository
public interface TheClassRepository extends JpaRepository<TheClass, Long> {
	@Query(value="select *from Lop where MaLop=:id",nativeQuery=true)
	TheClass getClassByID(@Param("id") String id);
    // List<TheClass> findByClassId(String classId);
}
