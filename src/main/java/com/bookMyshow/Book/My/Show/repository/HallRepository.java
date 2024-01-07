package com.bookMyshow.Book.My.Show.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookMyshow.Book.My.Show.models.Hall;


@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {

	
}
