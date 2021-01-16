package com.iit.lecturer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.lecturer.entities.Lecturer;
import com.iit.lecturer.models.LecturerResponse;
import com.iit.lecturer.repositories.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	private LecturerRepository lecturerRepository;


	@Override
	public List<LecturerResponse> getLecturers() {

		List<Lecturer> lecturers = lecturerRepository.findAll();

		List<LecturerResponse> response = new ArrayList<>();
		for (Lecturer lecturer : lecturers) {

			LecturerResponse lecturerResponse = new LecturerResponse(lecturer.getId(), lecturer.getName(),
					lecturer.getEmail(), lecturer.getContact());
			response.add(lecturerResponse);
		}

		return response;
	}

	@Override
	public LecturerResponse getLecturer(Long id) {
		
		LecturerResponse response = new LecturerResponse();
		Optional<Lecturer> optionalLecturer = lecturerRepository.findById(id);
		if(optionalLecturer.isPresent()) {
			
			response.setId(optionalLecturer.get().getId());
			response.setName(optionalLecturer.get().getName());
			response.setEmail(optionalLecturer.get().getEmail());
			response.setContact(optionalLecturer.get().getContact());
		}
		return response;
	}

}
