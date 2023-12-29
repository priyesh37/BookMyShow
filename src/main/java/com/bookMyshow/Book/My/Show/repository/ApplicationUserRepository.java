package com.bookMyshow.Book.My.Show.repository;

import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,UUID> {

	
}
