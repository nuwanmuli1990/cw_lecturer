package com.iit.lecturer.service;

import java.util.List;

import com.iit.lecturer.models.LecturerResponse;

public interface LecturerService {

	List<LecturerResponse> getLecturers();
	
	LecturerResponse getLecturer(Long id);

}
