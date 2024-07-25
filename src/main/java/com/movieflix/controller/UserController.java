package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entity.Movie;
import com.movieflix.entity.User;
import com.movieflix.repository.UserRapository;
import com.movieflix.services.MovieService;
import com.movieflix.services.Userservice;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	Userservice usrser;
	@Autowired
	MovieService movser;
	@Autowired
	UserRapository repo;
	
	
	public UserController(Userservice usrser) {
		super();
		this.usrser = usrser;
	}


	@PostMapping("register")
	public String emailExists(@ModelAttribute User us)
	 {
		boolean status=usrser.emailExists(us.getEmail());
		if(status==true)
		{
			System.out.println("email already exists");
			return "register";
		}
		else
		{
			usrser.userRegister(us);
			System.out.println("user has been added");
			return "registerSucess";
		}
		
	}
	
	
	@PostMapping("login")
	public String loginExits(@RequestParam String email,@RequestParam String password, HttpSession session) {
		boolean status=usrser.logInExists(email, password);
		
		if(status==true)
		{
			session.setAttribute("email",email);
			if(email.equals("admin@gmail.com"))
			{
				return "adminHome";
			}else
			{
			return "Home";
			}
		
			
		}else
		{
			return "login";
		}
		
	}
	
	@GetMapping("get-user")
	public String getAllUsers(Model model) {
		List<User> stdlist=usrser.getAllUsers();
		model.addAttribute("users", stdlist);
		return "viewUsers";
	}

	
	@GetMapping("exploremovie")
	public String exploreMovie(Model model,HttpSession session)
	{  
		
		//getting the email from session
		String email=(String)session.getAttribute("email");
		System.out.println(email);
		//getting the user details for mail
		User usr=usrser.getUser(email);
		//checking whether  is premium
		System.out.println(usr.isPremium());
		boolean status=usr.isPremium();
		if (status==true)
		{
			List<Movie> stdlist=movser.getAllMovie();
	 		model.addAttribute("movies", stdlist);
			return "viewMovieUser";
		}
	
		else
		{
			return "payment";
		}
		
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	
	 @GetMapping("update-profile")
	    public String editUser(Model model,HttpSession session) {
		 String email=(String)session.getAttribute("email");
	        User user = repo.findByEmail(email);
	        model.addAttribute("user", user);
	        return "edit-form"; // Your HTML form template
	    }
	


    @PostMapping("update-register")
    public String updUs(Model model,@RequestParam int id, @Validated @ModelAttribute User user, BindingResult rsult)
    {
    	User usr=repo.findById(id).get();
    	model.addAttribute("usr", usr);
    	usr.setName(user.getName());
    	usr.setEmail(user.getEmail());
    	usr.setGender(user.getGender());
    	usr.setPassword(user.getPassword());
    	usr.setAddress(user.getAddress());
    	usr.setPhone(user.getPhone());
    	repo.save(usr);
    	return "home";
    }
    
	
	

}
