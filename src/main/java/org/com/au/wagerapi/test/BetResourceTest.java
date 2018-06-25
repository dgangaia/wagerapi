package org.com.au.wagerapi.test;

import org.junit.Test;

import io.restassured.RestAssured;

public class BetResourceTest {
	
	final String uri = "http://localhost:8080/wagerapi/resource/bet/investment/bettypes";
	
	@Test
	public void testallinvestmenttypebybettype() {
		RestAssured.given().
		auth().
		preemptive().
		basic("user", "password").
		when().
		get(uri).
		then().
		statusCode(200);
	}

}
