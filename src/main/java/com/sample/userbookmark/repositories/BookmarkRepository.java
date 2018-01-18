package com.sample.userbookmark.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.userbookmark.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{
	
	Collection<Bookmark> findByUserAccountUsername(String username);
	
	@Query("Select b from Bookmark b where b.isPublic = 'Y'")
	Collection<Bookmark> findAllPublicBookmarks();
}
