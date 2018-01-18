package com.sample.userbookmark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserProfile {
	private String firstName;
	private String lastName;
	private String emailID;
	
	@Id
	@GeneratedValue
	private long id;
	
	@JsonIgnore
    @OneToOne
	private UserAccount userProfile;
	
	UserProfile() {
		
	}
	
	public UserProfile(String firstName, String lastName, String emailID, UserAccount userAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.userProfile = userAccount;
	}
	
	public String getFirstName() {
		return firstName;
	}
		
	public String getLastName() {
		return lastName;
	}
	
	public String getEmailID() {
		return emailID;
	}
	
	public UserAccount getUserProfile() {
		return userProfile;
	}

}
