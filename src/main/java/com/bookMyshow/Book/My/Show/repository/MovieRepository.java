package com.bookMyshow.Book.My.Show.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookMyshow.Book.My.Show.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
