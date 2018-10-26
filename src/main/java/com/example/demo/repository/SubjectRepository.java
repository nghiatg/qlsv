/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

/**
 * @author User
 *
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

}
