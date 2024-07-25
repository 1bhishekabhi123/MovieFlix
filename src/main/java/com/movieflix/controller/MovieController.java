package com.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieflix.entity.Movie;

import com.movieflix.services.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movser;

	public MovieController(MovieService movser) {
		super();
		this.movser = movser;
	}
     @PostMapping("addmovie")
	public String addMovie(@ModelAttribute Movie mov) {
		movser.CreateMovie(mov);
		return "adminHome";
	}
     
     
     
     
     @GetMapping("view-movie")
 	public String getAllMovies(Model model) {
 		List<Movie> stdlist=movser.getAllMovie();
 		model.addAttribute("movies", stdlist);
 		return "viewMovie";
     }
 		 @GetMapping("viewmovie")
 	 	public String getAllMovie(Model model) {
 	 		List<Movie> stdlist=movser.getAllMovie();
 	 		model.addAttribute("movies", stdlist);
 	 		return "viewMovieUser";
 	}

}
