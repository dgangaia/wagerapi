package org.com.au.wagerapi.test;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.AssertTrue;
import javax.ws.rs.core.Response;

import org.com.au.wagerapi.resources.CustomerResource;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CustomerTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;

	}

	@Test
	public void testCustomerResource() {
		CustomerResource cust = new CustomerResource();		
		assertEquals("dixit",cust.getCustomerResource());
	}

	

}
