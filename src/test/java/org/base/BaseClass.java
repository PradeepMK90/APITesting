package org.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
	
public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	public void addHeader(String key, String value) {
		reqSpec= RestAssured.given().header(key,value);
	}
	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
	public void pathParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
	public  void basicAuth(String  key, String value) {
		reqSpec = reqSpec.auth().preemptive().basic(key, value);
		
	}
	public void addPayload(String body) {
		reqSpec = reqSpec.body(body);
	}
	public void addPayload(Object body) {
		reqSpec = reqSpec.body(body);
	}
	public Response requestType(String type,String endpoint) {
		switch(type) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;
		}
		return response;
	}
	public String getPropertyValue(String key) throws IOException {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		Object obj = properties.get(key);
		String s =(String)obj;
		return s;

	}
	public int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	public ResponseBody getResBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}
	public String getBodyAsString() {
		String asString = getResBody(response).asString();
		return asString;
	}
	public String getBodyAsPrettyString(Response response) {
		String asPrettyString = getResBody(response).asPrettyString();
		return asPrettyString;
	}
	public String jsonPath(String key, Response response) {
		JsonPath jsonPath = getResBody(response).jsonPath();
		Object object = jsonPath.get(key);
		String value = (String) object;
		return value;
	}
	public int jsonPathNum(String key, Response response) {
		JsonPath jsonPath = getResBody(response).jsonPath();
		Object object = jsonPath.get(key);
		int value = (int) object;
		return value; 
	}
	public void addHeaders(Headers header) {
		reqSpec = RestAssured.given().headers(header);
	}
}
