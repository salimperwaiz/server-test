package server.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import server.data.model.Movie;

@Path("/api/movie")
@Produces(MediaType.APPLICATION_JSON)
public interface MovieService {

	@GET
	public List<Movie> list();

	@POST
	public Response add(Movie movie);

	@PUT
	public Response update(Movie movie);

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id);

}
