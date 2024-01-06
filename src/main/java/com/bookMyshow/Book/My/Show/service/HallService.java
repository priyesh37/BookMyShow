package com.bookMyshow.Book.My.Show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyshow.Book.My.Show.dto.request.HallOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.models.Hall;
import com.bookMyshow.Book.My.Show.repository.ApplicationUserRepository;
import com.bookMyshow.Book.My.Show.repository.HallRepository;

@Service
public class HallService {
	
	  @Autowired
	  ApplicationUserRepository applicationUserRepository;
	  
	  @Autowired
	  HallRepository hallRepository;
	  
	  
	 public ApplicationUser signUp(HallOwnerSignUpDTO hallOwnerSignUpDTO){
	        ApplicationUser hallOwner = new ApplicationUser();
	        hallOwner.setName(hallOwnerSignUpDTO.getName());
	        hallOwner.setEmail(hallOwnerSignUpDTO.getEmail());
	        hallOwner.setPassword(hallOwnerSignUpDTO.getPassword());
	        hallOwner.setType(hallOwnerSignUpDTO.getType().toString());
	        hallOwner.setPhoneNumber(hallOwnerSignUpDTO.getPhoneNumber());
	        hallOwner.setAge(hallOwnerSignUpDTO.getCompanyAge());
	        List<Hall> halls = hallOwnerSignUpDTO.getHalls();
	        applicationUserRepository.save(hallOwner);
	        for(Hall hall : halls){
	            hall.setOwner(hallOwner);
	            hallRepository.save(hall);
	        }
	        return hallOwner;
	    }

}
