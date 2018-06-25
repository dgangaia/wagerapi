package org.com.au.wagerapi.utilites;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.com.au.wagerapi.model.ErrorMessage;
import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		final String path = requestContext.getUriInfo().getPath();
		final boolean openUrl = path.startsWith("customer") || path.startsWith("bet") || path.startsWith("transaction");
		if(openUrl){
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeader != null && authHeader.size()>0){
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodeString = new String(Base64.decodeAsString(authToken));
				StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				if("user".equals(username) && "password".equals(password)){
					System.out.println("User is authenticated succefully");
					return ;
				}
			}
			ErrorMessage errorMessage = new ErrorMessage("User not authorized to access the resource.", 401 , "Please provide User name and password or token to Authenticate");
			Response unauthorizedStatus = Response
					.status(Response.Status.UNAUTHORIZED)
					.entity(errorMessage)
					.build();
			requestContext.abortWith(unauthorizedStatus);

		}
	}
}
