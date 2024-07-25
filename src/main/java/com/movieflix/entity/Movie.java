package com.movieflix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     int id;
	String movieName;
	@Column(length=2000)
	String movieLink;
	String genre;
	String cast;
	String Director;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String movieName, String movieLink, String genre, String cast, String director) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieLink = movieLink;
		this.genre = genre;
		this.cast = cast;
		Director = director;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieLink() {
		return movieLink;
	}
	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieLink=" + movieLink + ", genre=" + genre
				+ ", cast=" + cast + ", Director=" + Director + "]";
	}
	

}
