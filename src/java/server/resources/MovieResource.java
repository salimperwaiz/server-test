package server.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.dropwizard.hibernate.UnitOfWork;
import server.data.model.Movie;
import server.db.MovieDao;

@Path("/api/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({ MediaType.APPLICATION_JSON })
public class MovieResource {

	MovieDao movieDao;

	public MovieResource(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	@GET
	@UnitOfWork
	public List<Movie> getAll() {
		return movieDao.getAll();
	}

	@POST
	@UnitOfWork
	public Movie add(@Valid Movie movie) {
		Movie newMovie = movieDao.insert(movie);

		return newMovie;
	}

	@PUT
	@UnitOfWork
	public Movie update(@Valid Movie movie) {
		movieDao.update(movie);
		return movie;
	}

	@DELETE
	@Path("/{id}")
	@UnitOfWork
	public Response delete(@PathParam("id") Integer id) {
		Movie movie = movieDao.findById(id);

		Response response;
		if (movie != null) {
			movieDao.delete(movie);
			response = Response.ok().build();
		} else {
			throw new RuntimeException("Movie to delete not found");
		}
		return response;

	}

}
