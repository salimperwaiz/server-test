package server.data.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

	private long id;
	private String name;
	private String genre;
	private Date year_released;
	private float rating;

	public Movie() {

	}

	public Movie(long id, String name, String genre, Date year_released, float rating) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.year_released = year_released;
		this.rating = rating;
	}

	@JsonProperty
	public long getId() {
		return id;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public String getGenre() {
		return genre;
	}

	@JsonProperty
	public Date getYear_released() {
		return year_released;
	}

	@JsonProperty
	public float getRating() {
		return rating;
	}

}
