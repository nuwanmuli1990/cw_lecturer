package com.iit.lecturer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.lecturer.entities.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{

	
}
