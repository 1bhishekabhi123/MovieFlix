package com.movieflix.services;

import java.util.List;

import com.movieflix.entity.Movie;

public interface MovieService {
	public String CreateMovie(Movie mov);
	public List<Movie> getAllMovie();

}
