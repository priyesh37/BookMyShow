package com.bookMyshow.Book.My.Show.service;

import com.bookMyshow.Book.My.Show.dto.request.RegularUserSignupDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RegularUserService {
	
	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	public ApplicationUser signup(RegularUserSignupDTO regularUserSignupDTO) {
		
		ApplicationUser user = new ApplicationUser();
		user.setAge(regularUserSignupDTO.getAge());
		user.setName(regularUserSignupDTO.getName());
		user.setEmail(regularUserSignupDTO.getEmail());
		user.setPassword(regularUserSignupDTO.getPassword());
		user.setPhoneNumber(regularUserSignupDTO.getPhoneNumber());
		user.setType(regularUserSignupDTO.getType().toString());
		
		applicationUserRepository.save(user);
		return user;
		
	}

	public ApplicationUser getUserByEmail(String email){
		return applicationUserRepository.findByEmail(email);
	}

}
