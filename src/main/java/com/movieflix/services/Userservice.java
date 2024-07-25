package com.movieflix.services;

import java.util.List;

import com.movieflix.entity.User;

public interface Userservice {
	public String userRegister(User us);
	public boolean emailExists(String email);
	public boolean logInExists(String email,String password);
	public List<User> getAllUsers();
	public User getUser(String email);
	public void updateUser(User user);
	
}
