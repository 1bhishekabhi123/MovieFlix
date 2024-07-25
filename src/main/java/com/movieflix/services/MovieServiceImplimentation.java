package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entity.Movie;
import com.movieflix.entity.User;
import com.movieflix.repository.MovieRepository;
@Service
public class MovieServiceImplimentation implements MovieService{
	@Autowired
    MovieRepository movieRepo;
	
	
	public MovieServiceImplimentation(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}


	@Override
	public String CreateMovie(Movie mov) {
		movieRepo.save(mov);
		return "movie is saved";
	}


	@Override
	public List<Movie> getAllMovie() {
		List<Movie> ul=movieRepo.findAll();
		return ul;
		
	}
	

}
