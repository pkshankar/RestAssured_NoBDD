package com.qa.test;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pojo.RestfulBookerCreateUser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRestFulBooker {

	@Test(enabled = true)
	public void createTokenSerialization() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType("application/json");
		RestfulBookerCreateUser ob = new RestfulBookerCreateUser("admin", "password123");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonPayload = mapper.writeValueAsString(ob);
			httpRequest.body(jsonPayload);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

		Response response = httpRequest.post("/auth");
		JsonPath jPath = response.jsonPath();
		System.out.println("TOKEN WITH SERIALIZATION: " + jPath.get("token"));

	}

	@Test
	public void createTokenWithoutSerialization() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType("application/json");
		String jsonPayload = "{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n"
				+ "}";
		httpRequest.body(jsonPayload);
		Response response = httpRequest.post("/auth");
		JsonPath jPath = response.jsonPath();
		System.out.println("TOKEN WITHOUT SERIALIZATION: " + jPath.get("token"));
	}

	@Test
	public void createTokenJsonFile() {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType("application/json");
		File file = new File(
				"C:\\Users\\pkshank\\eclipse-workspace\\RestAssured_NoBDD\\src\\main\\java\\com\\qa\\jsonfile\\createToken.json");
		httpRequest.body(file);
		Response response = httpRequest.post("/auth");
		JsonPath jPath = response.jsonPath();
		System.out.println("TOKEN WITH FILE CONCEPT: " +jPath.get("token"));
	}
	
	@Test
	public void createTokenJsonObj() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType("application/json");
		JSONObject jObj = new JSONObject();
		jObj.put("username", "admin");
		jObj.put("password", "password123");
		String jsonPayload = jObj.toJSONString();
		httpRequest.body(jsonPayload);
		Response response = httpRequest.post("/auth");
		JsonPath jp = response.jsonPath();
		System.out.println("TOKEN WITH JSON OBJECT CONCEPT: " + jp.get("token"));
	}
}
