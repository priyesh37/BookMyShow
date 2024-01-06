package com.bookMyshow.Book.My.Show.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shows {
	
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	    UUID id;
	 	
	    @JsonIgnore
	    @ManyToOne
	    Hall hall;
	    
	    @JsonIgnore
	    @ManyToOne
	    Movie movie;
	    
	    @JsonIgnore
	    @ManyToOne
	    Screen screen;
	    
	    int availableTickets;
	    
	    Date startTime;
	    
	    Date endTime;
	    
	    int ticketPrice;
	    
	    @OneToMany(mappedBy = "show")
	    List<Ticket> tickets;

	
}
