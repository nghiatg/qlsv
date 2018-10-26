package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
