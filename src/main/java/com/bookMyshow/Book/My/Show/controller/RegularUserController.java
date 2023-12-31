package com.bookMyshow.Book.My.Show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookMyshow.Book.My.Show.dto.request.RegularUserSignupDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.service.RegularUserService;

@RestController
@RequestMapping("/user")
public class RegularUserController {

	@Autowired
	RegularUserService regularUserService;
	@PostMapping("/signup")
	public ResponseEntity signUp(@RequestBody RegularUserSignupDTO regularUserSignupDTO){
		
		ApplicationUser user = regularUserService.signup(regularUserSignupDTO);
		return new ResponseEntity(user,HttpStatus.CREATED);
	}


}

