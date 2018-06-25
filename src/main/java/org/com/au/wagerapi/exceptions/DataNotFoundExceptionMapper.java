package org.com.au.wagerapi.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.com.au.wagerapi.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		System.out.println("DataNotFoundExceptionMapper");
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404 , "Please refer to documentation");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
