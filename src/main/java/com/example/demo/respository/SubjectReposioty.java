package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;
@Repository
public interface SubjectReposioty extends JpaRepository<Subject, Long> {

}
