package org.restassuredvels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.base.Endpoints;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class LoginVels extends BaseClass {
	
	String logtoken;
	int jsonPathNum;
	@Test(priority = 1)
	public void LoginV() throws IOException {	
		
	addHeader("Content-Type" , "application/json");
	basicAuth(getPropertyValue("email"), getPropertyValue("password"));
	Response response = requestType("POST",Endpoints.LOGIN);
	int responseCode = getResponseCode(response);
	System.out.println(responseCode);
	String bodyAsPrettyString = getBodyAsPrettyString(response);
	System.out.println(bodyAsPrettyString);
	
	logtoken = jsonPath("data.logtoken", response);
	System.out.println(logtoken);
	
	}
	@Test(priority = 2)
	private void CreateAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header ("accept", "application/json");
		Header h2 = new Header ("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);
		
		Headers headers = new Headers(header);
		addHeaders(headers);		
		
		addPayload("{\r\n"
				+ "  \"first_name\": \"Arun\",\r\n"
				+ "  \"last_name\": \"Kumar\",\r\n"
				+ "  \"mobile\": \"1234567898\",\r\n"
				+ "  \"apartment\": \"apartment\",\r\n"
				+ "  \"state\": 33,\r\n"
				+ "  \"city\": 3378,\r\n"
				+ "  \"country\": 101,\r\n"
				+ "  \"zipcode\": \"202020\",\r\n"
				+ "  \"address\": \"64/63 partap nagar\",\r\n"
				+ "  \"address_type\": \"home\"\r\n"
				+ "}");
		
		Response response = requestType("POST",Endpoints.ADD_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		 jsonPathNum = jsonPathNum("address_id", response);
		String msg = jsonPath("message", response);
		Assert.assertEquals(msg,"Address added successfully", "Verify address created successfully");
			
	}
	@Test(priority = 3)
	private void UpdateAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header ("accept", "application/json");
		Header h2 = new Header ("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);
		
		Headers headers = new Headers(header);
		addHeaders(headers);		
		
		addPayload("{\r\n"
				+ "  \"address_id\": \""+jsonPathNum+"\",\r\n"
				+ "  \"first_name\": \"Raj\",\r\n"
				+ "  \"last_name\": \"Khundra\",\r\n"
				+ "  \"mobile\": \"1234567898\",\r\n"
				+ "  \"apartment\": \"apartment\",\r\n"
				+ "  \"state\": 33,\r\n"
				+ "  \"city\": 3378,\r\n"
				+ "  \"country\": 101,\r\n"
				+ "  \"zipcode\": \"202020\",\r\n"
				+ "  \"address\": \"64/63 partap nagar\",\r\n"
				+ "  \"address_type\": \"home\"\r\n"
				+ "}");
		Response response = requestType("PUT",Endpoints.UPDATE_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		String msg = jsonPath("message", response);
		Assert.assertEquals(msg,"Address updated successfully", "Verify address updated successfully");
	
	}
	@Test(priority = 4)
	private void GetAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header ("Authorization", "Bearer "+logtoken);
		header.add(h1);
		header.add(h2);
		
		Headers headers = new Headers(header);
		addHeaders(headers);		
		
		Response response = requestType("GET",Endpoints.GET_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		String msg = jsonPath("message", response);
		Assert.assertEquals(msg,"OK", "Verify address got successfully");
	
	}
	@Test(priority = 5)
	private void DeleteAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header ("Authorization", "Bearer "+logtoken);
		header.add(h1);
		header.add(h2);
		
		Headers headers = new Headers(header);
		addHeaders(headers);		
		
		addPayload("{\r\n"
				+ "  \"address_id\": \""+jsonPathNum+"\",\r\n"
				+ "  \"first_name\": \"Raj\",\r\n"
				+ "  \"last_name\": \"Khundra\",\r\n"
				+ "  \"mobile\": \"1234567898\",\r\n"
				+ "  \"apartment\": \"apartment\",\r\n"
				+ "  \"state\": 33,\r\n"
				+ "  \"city\": 3378,\r\n"
				+ "  \"country\": 101,\r\n"
				+ "  \"zipcode\": \"202020\",\r\n"
				+ "  \"address\": \"64/63 partap nagar\",\r\n"
				+ "  \"address_type\": \"home\"\r\n"
				+ "}");
		Response response = requestType("DELETE",Endpoints.DELETE_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		String msg = jsonPath("message", response);
		Assert.assertEquals(msg,"Address deleted successfully", "Verify address updated successfully");
			

	}

	
}
