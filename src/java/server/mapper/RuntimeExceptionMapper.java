package server.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class RuntimeExceptionMapper implements
		ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException e) {
		
		return Response.serverError().entity(e.getMessage()).build();
	}
}
