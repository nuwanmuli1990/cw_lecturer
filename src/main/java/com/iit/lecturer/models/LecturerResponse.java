package com.iit.lecturer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerResponse {

	private Long id;
	private String name;
	private String email;
	private String contact;
}
