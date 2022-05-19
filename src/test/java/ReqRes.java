import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReqRes {
public static void main(String[] args) throws IOException, ParseException {
	FileReader reader = new FileReader("C:\\Users\\prade\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\JSON Files\\reqres.json");
	JSONParser jsonParser = new JSONParser();
	Object object = jsonParser.parse(reader);
	JSONObject j = (JSONObject) object;
	Object objData = j.get("data");
	System.out.println(objData);
	Object objSupport = j.get("support");
	JSONObject j1 = (JSONObject) objSupport;
	Object url = j1.get("url");
	System.out.println(url);
	Object text = j1.get("text");
	System.out.println(text);
}
}
