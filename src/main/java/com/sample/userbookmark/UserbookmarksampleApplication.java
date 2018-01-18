package com.sample.userbookmark;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.userbookmark.model.Bookmark;
import com.sample.userbookmark.model.UserAccount;
import com.sample.userbookmark.model.UserProfile;
import com.sample.userbookmark.repositories.BookmarkRepository;
import com.sample.userbookmark.repositories.UserAccountRepository;
import com.sample.userbookmark.repositories.UserProfileRepository;

@SpringBootApplication
public class UserbookmarksampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserbookmarksampleApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserAccountRepository accountRepository,
			BookmarkRepository bookmarkRepository, UserProfileRepository userProfileRepository) {
		return (evt) -> Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(
						a -> {
							UserAccount account = accountRepository.save(new UserAccount(a,
									"password"));
							
							userProfileRepository.save(new UserProfile(a,"testLastName","a@a.com",account));
							
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description", "Y"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description", "N"));
						});
	}
}
