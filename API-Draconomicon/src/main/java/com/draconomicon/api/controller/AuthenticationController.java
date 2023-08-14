package com.draconomicon.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.draconomicon.api.model.AuthenticationRequest;
import com.draconomicon.api.model.AuthenticationResponse;
import com.draconomicon.api.model.RegisterRequest;
import com.draconomicon.api.service.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private final AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
		
	}
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authentication(request));
	}
}