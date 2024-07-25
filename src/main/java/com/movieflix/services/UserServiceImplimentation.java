package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movieflix.entity.User;
import com.movieflix.repository.UserRapository;
@Service
public class UserServiceImplimentation implements Userservice{
      @Autowired 
	UserRapository usrrepo;
      
	public UserServiceImplimentation(UserRapository usrrepo) {
		super();
		this.usrrepo = usrrepo;
	}

	@Override
	public String userRegister(User us) {
		usrrepo.save(us);
		return "User is registered";
	}

	@Override
	public boolean emailExists(String email) {
		if(usrrepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	@Override
	public boolean logInExists(String email, String password) {
		User usr=usrrepo.findByEmail(email);
		String db_password=usr.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> ul=usrrepo.findAll();
		return ul;
	}

	@Override
	public User getUser(String email) {
		User usr=usrrepo.findByEmail(email);
		return usr;
	}

	@Override
	public void updateUser(User user) {
		usrrepo.save(user);
		
	}

	
	

}
