package com.iit.lecturer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.lecturer.models.AuthenticatioResponse;
import com.iit.lecturer.models.AuthenticationRequest;
import com.iit.lecturer.models.LecturerResponse;
import com.iit.lecturer.service.LecturerService;
import com.iit.lecturer.service.MyUserDetailsService;
import com.iit.lecturer.util.JwtUtil;

@RestController
public class LecturerController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private LecturerService lecturerService;
	
	@GetMapping(value = "/lecturers")
	@ResponseBody
	public List<LecturerResponse> getLecturers() {
		return lecturerService.getLecturers();
	}
	
	@GetMapping(value = "/lecturers/{id}")
	@ResponseBody
	public LecturerResponse getLecturer(@PathVariable Long id) {
		return lecturerService.getLecturer(id);
	}
	
	
	@RequestMapping(value ="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Incorect username or pasword",e);
		}
		final UserDetails userDetails=myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticatioResponse(jwt));
	}
}
