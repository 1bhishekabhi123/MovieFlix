package com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entity.User;

public interface UserRapository extends JpaRepository<User,Integer> {
	public User findByEmail(String email);
	

}
