package server.data.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

	private long id;
	private String name;
	private String genre;
	private Date year_released;
	private double rating;

	public Movie() {

	}

	public Movie(long id, String name, String genre, Date year_released, double rating) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.year_released = year_released;
		this.rating = rating;
	}

	public void setId(long id) {
		this.id = id;
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
	public double getRating() {
		return rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
