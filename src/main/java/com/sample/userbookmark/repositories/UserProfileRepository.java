package com.sample.userbookmark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.userbookmark.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
}
