package com.sample.userbookmark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookmark {
	
	@Id
	@GeneratedValue
	private long id;
	
	public String uri;
	
	public String description;
	
	public String isPublic;
	
	@JsonIgnore
    @ManyToOne
	private UserAccount userAccount;
	
	Bookmark() {
		
	}
	
	public Bookmark(UserAccount userAccount, String uri, String description, String isPublic) {
		this.uri = uri;
		this.description = description;
		this.userAccount = userAccount;
		this.isPublic = isPublic;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public String getDescription() {
		return description;
	}
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public String getIsPublic() {
		return isPublic;
	}
	
}
