package org.jsonwrite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWrite {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File file = new File(
				"C:\\Users\\prade\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\JSON Files\\write.json");
		ObjectMapper mapper = new ObjectMapper();

		ArrayList<Datum1> data = new ArrayList<Datum1>();

		Datum1 e1 = new Datum1(7, "michael.lawson@reqres.in", "Michael", "Lawson",
				"https://reqres.in/img/faces/7-image.jpg");
		Datum1 e2 = new Datum1(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson",
				"https://reqres.in/img/faces/8-image.jpg");
		Datum1 e3 = new Datum1(9, "tobias.funke@reqres.in", "Tobias", "Funke",
				"https://reqres.in/img/faces/9-image.jpg");
		Datum1 e4 = new Datum1(10, "byron.fields@reqres.in", "Byron", "Fields",
				"https://reqres.in/img/faces/10-image.jpg");
		Datum1 e5 = new Datum1(11, "george.edwards@reqres.in", "George", "Edwards",
				"https://reqres.in/img/faces/11-image.jpg");
		Datum1 e6 = new Datum1(12, "rachel.howell@reqres.in", "Rachel", "Howell",
				"https://reqres.in/img/faces/12-image.jpg");
		data.add(e1);
		data.add(e2);
		data.add(e3);
		data.add(e4);
		data.add(e5);
		data.add(e6);

		Support1 support = new Support1("https://reqres.in/#support-heading",
				"To keep ReqRes free, contributions towards server costs are appreciated!");

		PojoClass p = new PojoClass(2, 9, 12, 2, data, support);

		mapper.writeValue(file, p);

	}

}
