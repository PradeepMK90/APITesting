package org.array;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonArray {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader reader = new FileReader("C:\\Users\\prade\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\JSON Files\\array.json");
		JSONParser jsonParser = new JSONParser();
		Object object = jsonParser.parse(reader);
		JSONObject j = (JSONObject) object;
		Object objStudDetail = j.get("studDetails");
		JSONArray a = (JSONArray) objStudDetail;
		for (int i = 0; i < a.size(); i++) {
			Object allStudDetail = a.get(i);
			JSONObject j2 = (JSONObject) allStudDetail;
			System.out.println(j2.get("firstName"));
			System.out.println(j2.get("Course"));
			System.out.println(j2.get("Address"));
		}
	}
	
	
}
