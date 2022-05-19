package org.restassuredtestng;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ReqresPathOne {
	public static void main(String[] args) {
		Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");
		ResponseBody body = response.getBody();
		System.out.println(body.asPrettyString());
		JsonPath j = body.jsonPath();
		Object object1 = j.get("total");
		System.out.println(object1);
		Object object2 = j.get("data[4].last_name");
		System.out.println(object2);
		Object object3 = j.get("data.last_name");
		System.out.println(object3);
	}

}
