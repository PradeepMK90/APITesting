package org.ratestngwithserializationanddeserialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.base.Endpoints;
import org.ratestngpojo.AddAddress_Input_Pojo;
import org.ratestngpojo.AddAddress_Output_Pojo;
import org.ratestngpojo.DeleteAddress_Input_Pojo;
import org.ratestngpojo.DeleteAddress_Output_Pojo;
import org.ratestngpojo.GetAddress_Output_Pojo;
import org.ratestngpojo.Login_Output_Pojo;
import org.ratestngpojo.UpdateAddress_Input_Pojo;
import org.ratestngpojo.UpdateAddress_Output_Pojo;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Main_Vels_Pojo extends BaseClass{

	String logtoken;
	int jsonPathNum;
	int address_id;
	@Test(priority = 1)
	
	public void LoginV() throws IOException {	
		
	addHeader("Content-Type" , "application/json");
	basicAuth(getPropertyValue("email"), getPropertyValue("password"));
	Response response = requestType("POST",Endpoints.LOGIN);
	Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
	int responseCode = getResponseCode(response);
	System.out.println(responseCode);
	String bodyAsPrettyString = getBodyAsPrettyString(response);
	System.out.println(bodyAsPrettyString);
	
	logtoken = jsonPath("data.logtoken", response);
	System.out.println(logtoken);
	
	Assert.assertEquals(login_Output_Pojo.getMessage(),"Login successfully", "Verify address created successfully");
	
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
		AddAddress_Input_Pojo AddAddress_Input_Pojo= new AddAddress_Input_Pojo("Syed", "Mubharak", "9876543210", "Apartment", 33, 10, 50, "600097", "Chennai", "Home");
		addPayload(AddAddress_Input_Pojo);
		Response response = requestType("POST",Endpoints.ADD_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		System.out.println(addAddress_Output_Pojo);
		address_id = addAddress_Output_Pojo.getAddress_id();
		System.out.println(address_id);
		Assert.assertEquals(addAddress_Output_Pojo.getMessage(),"Address added successfully", "Verify address created successfully");
			
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
		
		UpdateAddress_Input_Pojo UpdateAddress_Input_Pojo = new UpdateAddress_Input_Pojo("1", "Syed", "Mubharak", "9876543210", "apartment", 33, 10, 50, "600097", "Chennai", "Home");
		addPayload(UpdateAddress_Input_Pojo);
		Response response = requestType("PUT",Endpoints.UPDATE_ADDRESS);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		System.out.println(updateAddress_Output_Pojo);
		Assert.assertEquals(updateAddress_Output_Pojo.getMessage(),"Address updated successfully", "Verify address updated successfully");
	
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
		GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		System.out.println(getBodyAsPrettyString(response));
		Assert.assertEquals(getAddress_Output_Pojo.getMessage(),"OK", "Verify address got successfully");
	
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
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(""+address_id+"");
		addPayload(deleteAddress_Input_Pojo);
		Response response = requestType("DELETE",Endpoints.DELETE_ADDRESS);
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		System.out.println(getResponseCode(response));
		System.out.println(getBodyAsPrettyString(response));
		String address_id = deleteAddress_Input_Pojo.getAddress_id();
		System.out.println(address_id);
		
		Assert.assertEquals(deleteAddress_Output_Pojo.getMessage(),"Address deleted successfully", "Verify address updated successfully");
			

	}

	
}
