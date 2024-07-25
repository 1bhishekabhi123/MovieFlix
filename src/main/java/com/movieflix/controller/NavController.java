package com.movieflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController {
	@GetMapping("user-signup")
	public String gotoRegister()
	{
		return "register";
	}
	@GetMapping("user-login")
	public String gotoLogin()
	{
		return "logIn";
	}
	
	@GetMapping("admin-home")
	public String gotoAdmin()
	{
		return "adminHome";
	}
	
	@GetMapping("get-movie")
	public String gotoAddMovie()
	{
		return "adminMovie";
	}
	@GetMapping("back-to")
	public String backto()
	{
		return "home";
	}
	
	
}
