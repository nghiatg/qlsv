/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EducationSystem;

/**
 * @author User
 *
 */
@Repository
public interface EducationSystemRepository extends JpaRepository<EducationSystem, String> {

}
