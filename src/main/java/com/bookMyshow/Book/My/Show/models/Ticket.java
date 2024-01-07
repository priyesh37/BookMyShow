package com.bookMyshow.Book.My.Show.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Ticket {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;

	    @ManyToOne
	    ApplicationUser user;
	    
	    @ManyToOne
	    Movie movie;
	    
	    @ManyToOne
	    Hall hall;
	    
	    @ManyToOne
	    Shows show;

}
