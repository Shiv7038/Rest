import io.restassured.path.json.JsonPath;

public class Util {

	public static JsonPath rawJson(String response) {
		JsonPath j=new JsonPath(response);
		return j;
	}


}
