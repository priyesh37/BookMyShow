package com.bookMyshow.Book.My.Show.controller;

import com.bookMyshow.Book.My.Show.dto.request.HallOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.dto.request.MovieOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.service.HallService;
import com.bookMyshow.Book.My.Show.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    HallService hallService;
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody HallOwnerSignUpDTO hallOwnerSignUpDTO){

        ApplicationUser user = hallService.signUp(hallOwnerSignUpDTO);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
}
