package com.sample.userbookmark.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.userbookmark.model.Bookmark;
import com.sample.userbookmark.repositories.BookmarkRepository;
import com.sample.userbookmark.repositories.UserAccountRepository;
import com.sample.userbookmark.repositories.UserProfileRepository;

@RestController
public class UserBookmarkController {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Autowired
	BookmarkRepository bookmarkRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@RequestMapping(method = RequestMethod.GET, value="/{userId}/bookmarks")
	Collection<Bookmark> readBookmarks(@PathVariable String userId) {
		return this.bookmarkRepository.findByUserAccountUsername(userId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{userId}/bookmarks/{bookmarkId}")
	void deleteUserBookmarks(@PathVariable Long bookmarkId) {
		this.bookmarkRepository.delete(bookmarkId);
	}

	@RequestMapping(method = RequestMethod.POST, value="/{userId}/bookmark")
	ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
		return this.userAccountRepository
				.findByUsername(userId)
				.map(account -> {
					Bookmark result = bookmarkRepository.save(new Bookmark(account,
							input.uri, input.description, input.isPublic));

					URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());

	}

	@RequestMapping(method = RequestMethod.GET, value = "/bookmarks/{bookmarkId}")
	Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		return this.bookmarkRepository.findOne(bookmarkId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bookmarks/public")
	Collection<Bookmark> readPublicBookmarks() {
		return this.bookmarkRepository.findAllPublicBookmarks();
	}
}

