package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@PostMapping("/login")
	public String login(@RequestBody Admin login) {
		boolean res = adminService.validateLogin(login.getUsername(), login.getPassword());
		return res?"Login Successful":"Invalid Credentials";
	}
}
