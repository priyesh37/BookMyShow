package com.bookMyshow.Book.My.Show.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyshow.Book.My.Show.dto.request.MovieOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.models.Movie;
import com.bookMyshow.Book.My.Show.repository.ApplicationUserRepository;
import com.bookMyshow.Book.My.Show.repository.MovieRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

	@Autowired
    MovieRepository movieRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    
    
    public ApplicationUser signUp(MovieOwnerSignUpDTO movieOwnerSignUpDTO){
    	
        ApplicationUser movieOwners = new ApplicationUser();
        movieOwners.setName(movieOwnerSignUpDTO.getName());
        movieOwners.setEmail(movieOwnerSignUpDTO.getEmail());
        movieOwners.setPassword(movieOwnerSignUpDTO.getPassword());
        movieOwners.setType(movieOwnerSignUpDTO.getType().toString());
        movieOwners.setPhoneNumber(movieOwnerSignUpDTO.getPhoneNumber());
        movieOwners.setAge(movieOwnerSignUpDTO.getCompanyAge());
        List<Movie> movies = movieOwnerSignUpDTO.getMovies();
        applicationUserRepository.save(movieOwners);
        for(Movie movie : movies){
            movie.setOwner(movieOwners);
            movieRepository.save(movie);
        }
        return movieOwners;
    }
}
