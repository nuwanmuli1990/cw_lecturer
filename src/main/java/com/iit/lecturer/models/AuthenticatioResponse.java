package com.iit.lecturer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticatioResponse {

	private final String jwt;
}
