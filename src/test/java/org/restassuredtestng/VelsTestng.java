package org.restassuredtestng;

import java.io.IOException;

import org.base.BaseClass;
import org.base.Endpoints;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VelsTestng extends BaseClass {
@Test
		public void login() throws IOException, ParseException {
			addHeader("Content-Type" , "application/json");
			basicAuth(getPropertyValue("email"), getPropertyValue("password"));
			Response response = requestType("POST",Endpoints.LOGIN);
			int responseCode = getResponseCode(response);
			System.out.println(responseCode);
			String bodyAsPrettyString = getBodyAsPrettyString(response);
			System.out.println(bodyAsPrettyString);
			JSONParser jsonParser= new JSONParser();
			Object parse = jsonParser.parse(bodyAsPrettyString);
			System.out.println(parse);
			JSONObject jsonObject = (JSONObject) parse;
		    Object objMsg = jsonObject.get("message");
			String msg = (String) objMsg;
			Assert.assertEquals(msg, "Login successfully", "Verify Login Successfully");
			Object objData = jsonObject.get("data");
			JSONObject j = (JSONObject) objData;
			Object objectLastName = j.get("last_name");
			String lastName = (String) objectLastName;
			Assert.assertEquals(lastName, "M K", "Verify Last Name");
			

	}

}
