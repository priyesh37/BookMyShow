package com.bookMyshow.Book.My.Show.models;

import java.util.List;
import java.util.UUID;

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
public class ApplicationUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	
	String name;
	
	@Column(unique=true)
	String email;
	
	@Column(unique=true)
	long phoneNumber;
	
	String password;
	
	String type; // movieOwners, HallOwners and RegularUserServce
	
	int age;
	
	@OneToMany(mappedBy = "user")
	List<Ticket> tickets;
}
