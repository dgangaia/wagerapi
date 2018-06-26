package org.com.au.wagerapi.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.com.au.wagerapi.model.ErrorMessage;


@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException>{

	@Override
	public Response toResponse(UserNotFoundException ex) {
		System.out.println("UserNotFoundException");
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404 , "Please refer to documentation");
		return Response.status(Status.NOT_FOUND)
				.type(MediaType.APPLICATION_JSON)
				.entity(errorMessage)
				.build();
	}
}