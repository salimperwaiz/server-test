package server.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
    @Column(name = "ID", nullable = false)
    @NotNull
    @JsonProperty
	private Integer id;

	@Column(name = "NAME", length = 100, nullable = false)
	@NotNull
	@JsonProperty
	private String name;

	@Column(name = "GENRE", length = 10, nullable = false)
	@NotNull
	@JsonProperty
	private String genre;

	@NotNull
	@JsonProperty
	private Date year_released;

	@JsonProperty
	private Integer rating;

	public Movie() {

	}

	public Movie(Integer id, String name, String genre, Date year_released, Integer rating) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.year_released = year_released;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getYear_released() {
		return year_released;
	}

	public void setYear_released(Date year_released) {
		this.year_released = year_released;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
