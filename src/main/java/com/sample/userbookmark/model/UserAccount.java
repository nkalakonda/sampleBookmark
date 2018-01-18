package com.sample.userbookmark.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {
	
	
	private String username;
	private String password;
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy = "userAccount")
	private Set<Bookmark> bookmarks = new HashSet<Bookmark>();
	
	@OneToOne(mappedBy = "userProfile")
	private UserProfile userProfile;
	
	UserAccount() {
		
	}
	
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
				
	public String getUsername() {
		return username;
	}
		
	public String getPassword() {
		return password;
	}
		
	public long getId() {
		return id;
	}
		
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
}
