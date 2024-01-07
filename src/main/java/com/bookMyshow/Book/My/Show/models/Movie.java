package com.bookMyshow.Book.My.Show.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	String directorName;
	
	String actorName;
	
	String actressName;
	
	int imdbRating;
	
	double duration;
	
	@OneToMany(mappedBy = "movie")
	List<Ticket> tickets ;
	
	@ManyToOne
	ApplicationUser owner ; 
}
