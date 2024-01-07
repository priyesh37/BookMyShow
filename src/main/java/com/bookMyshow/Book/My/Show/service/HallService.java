package com.bookMyshow.Book.My.Show.service;

import java.util.List;
import java.util.Optional;

import com.bookMyshow.Book.My.Show.Exception.ResourceNotExistException;
import com.bookMyshow.Book.My.Show.Exception.UnAuthorized;
import com.bookMyshow.Book.My.Show.Exception.userNotFoundException;
import com.bookMyshow.Book.My.Show.dto.request.AddScreenDTO;
import com.bookMyshow.Book.My.Show.models.Screen;
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

	  @Autowired
	  RegularUserService regularUserService ;
	  
	  @Autowired
	  ScreenService screenService;
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

		public Optional<Hall> getHallById(int id){
			return hallRepository.findById(id);
		}

		public void addScreens(AddScreenDTO addScreenDTO, String email) throws userNotFoundException, UnAuthorized, ResourceNotExistException {

		 		List<Screen> screens = addScreenDTO.getScreens();
				 int hallId = addScreenDTO.getHallId();

				 ApplicationUser user = regularUserService.getUserByEmail(email);
				 if(user==null){
					 throw new userNotFoundException("User with this Email does not exist");
				 }
				 if(!user.getType().equals("HallOwner")){
					 throw  new UnAuthorized("User does not has access to perform this task");
				 }

				 Hall hall = getHallById(hallId).orElse(null);
				 if(hall == null){
					 throw new ResourceNotExistException(String.format("Hall with id %s does not exist",hallId));
				 }
				if(hall.getOwner().getId() != user.getId()){
					throw new UnAuthorized("User does not own this hallId");
				}
				for (Screen screen : screens){
					screen.setHall(hall);
					screenService.registerScreen(screen);
				}

		}



}
