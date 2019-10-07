package com.qa.test;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidation {
	
	@Test
	public void validateSchema() {
		
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/public-api/users?access-token=9tms9x_ejVmAxTrC9GxY1vjfg_vW2SiJh9NM");
		response.body();
		
		
				// /public-api/users?access-token=9tms9x_ejVmAxTrC9GxY1vjfg_vW2SiJh9NM"
		
	}

}
