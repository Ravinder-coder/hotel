package com.hma.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hma.demo.entity.Admin;
import com.hma.demo.service.AdminService;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	AdminService adminService;


	@PostMapping("/register")
	public ResponseEntity<Admin>register(@RequestBody Admin admin) {

		return new ResponseEntity<>(adminService.register(admin),HttpStatus.OK);

	}
	
	@PostMapping("/signin")
	public ResponseEntity<String>signIn(@RequestParam String adminName, @RequestParam String adminPassword) {
	
		return new ResponseEntity<>(adminService.signIn(adminName, adminPassword),HttpStatus.OK);
	}

}