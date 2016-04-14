package server.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import server.data.model.Movie;

public class MovieServiceImpl implements MovieService {

	private long currentId = 113;
	Map<Long, Movie> movies = new HashMap<>();

	public MovieServiceImpl() {
		init();
	}

	final void init() {
		movies.put(110L, new Movie(110, "Gladiator", "Action", new Date(), 3.5));
		movies.put(111L, new Movie(111, "Superman", "Action", new Date(), 3.0));
		movies.put(112L, new Movie(112, "Spiderman", "Action", new Date(), 3.2));
		movies.put(113L, new Movie(113, "Mockingjay", "Action", new Date(), 3.2));
	}

	public Response add(Movie movie) {
		movie.setId(++currentId);
		movies.put(movie.getId(), movie);
		return Response.ok(movie).build();
	}

	public List<Movie> list() {
		List<Movie> moviesList = new ArrayList<>();
		for (Long key : movies.keySet()) {
			moviesList.add(movies.get(key));
		}
		return moviesList;
	}

	public Response update(Movie updatedMovie) {
		Movie currentMovie = movies.get(updatedMovie.getId());
		Response response = null;
		if (currentMovie != null) {
			movies.put(updatedMovie.getId(), updatedMovie);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	public Response delete(String id) {
		Long movieId = Long.parseLong(id);
		Movie movie = movies.get(movieId);
		Response response = null;
		if (movie != null) {
			movies.remove(movieId);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	public int getCount() {
		return movies.size();
	}

}
