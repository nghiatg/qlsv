package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TheClass;

public interface TheClassServiceImpl {
    TheClass getClassById(String classId);
    void save(TheClass cTheClass);
}
