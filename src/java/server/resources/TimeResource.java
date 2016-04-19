package server.resources;

import java.time.LocalTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/timeofday")
public class TimeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCurrentTime() {
		return Response.ok(LocalTime.now()).build();
	}

}
