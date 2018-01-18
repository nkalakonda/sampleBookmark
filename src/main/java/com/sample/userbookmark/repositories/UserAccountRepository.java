package com.sample.userbookmark.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.userbookmark.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	Optional<UserAccount> findByUsername(String username);

}
