package org.apivels;

import java.io.IOException;

import org.base.BaseClass;
import org.base.Endpoints;

import io.restassured.response.Response;

public class VelsMain extends BaseClass{
	public void login() throws IOException {
		addHeader("Content-Type" , "application/json");
		basicAuth(getPropertyValue("email"), getPropertyValue("password"));
		Response response = requestType("POST",Endpoints.LOGIN);
		int responseCode = getResponseCode(response);
		System.out.println(responseCode);
		String bodyAsPrettyString = getBodyAsPrettyString(response);
		System.out.println(bodyAsPrettyString);
	}
	public static void main(String[] args) throws IOException {
		VelsMain sample = new VelsMain();
		sample.login();
	}

}
