package org.com.au.wagerapi.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;

public class BasicAuthTest {

	final String uri = "http://localhost:8080/wagerapi/resource/customer/details/";
	final String username = "user";
	final String password = "password";

	@Test
	public void testbasicAuthValidPassword_200() {

		final String uri = "http://localhost:8080/wagerapi/resource/customer/details/";
		//RestAssured.given().auth().basic("user", "password").when().get(uri).then().statusCode(200);
		RestAssured.given().auth().preemptive().basic(username, password).when().get(uri).then().statusCode(200);
		/*
		final String uri = "http://localhost:8080/wagerapi/resource/customer/details/";
		final RequestSpecification basicAuth = RestAssured.given().auth().preemptive().basic("user", "password");
		final Response response =  (Response) basicAuth.accept(ContentType.JSON).get(uri);
		CustomerResource cust = new CustomerResource();		
		AssertTrue(response.getStatus(),Matchers.equalTo(200));*/
	}


	@Test
	public void testbasicAuthInValidusername_401() {
		RestAssured.given().
		auth().
		preemptive().
		basic("user1", "password").
		when().
		get(uri).
		then().
		statusCode(401);
	}


	@Test
	public void testbasicAuthInValidPassword_401() {
		RestAssured.given().
		auth().
		preemptive().
		basic("user", "invalid").
		when().
		get(uri).
		then().
		statusCode(401);
	}

	@Test
	public void testValidToken_200() {

		RestAssured.
		given().
		header("Authorization", "Basic dXNlcjpwYXNzd29yZA==").
		when().
		get(uri).
		then().
		statusCode(200).log().all();
	}


	@Test
	public void testInValidToken_401() {
		RestAssured
		.given()
		.header("Authorization", "Basic dXNlcjpwYXNzA===")
		.when()
		.get(uri)
		.then()
		.statusCode(401).log().all();
		//.extract().jsonPath();

	}
	
	
	@Test
	public void testInvalidContentType_500() {

		RestAssured.given().
		accept("application/xml").
		contentType("application/xml").
		header("authorization", "Basic "+"dXNlcjpwYXNzd29yZA==").
		when().
		get(uri).
		then().
		statusCode(500).log().all();
	}

}
