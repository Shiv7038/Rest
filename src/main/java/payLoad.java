import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.payload;

public class payLoad {


	public static void main(String[] args) {
		//Add place ->Update Place with new address ->Get place to validate if new address is present in responce
				RestAssured.baseURI="https://rahulshettyacademy.com";
				String response=given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json")
				.body(payload.addPayLoad())  //add payload in addPayLoad method
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.41 (Ubuntu)")
				.extract().response().asString();  //Extract the response in string format --> return String
				
				System.out.println(response);
				JsonPath js= new JsonPath(response); //JsonPath class take input in string format and convert into Json format  -->meanse for parsing json
				
				String placeId=js.getString("place_id"); //this method extract the response body as a String, which accept the String path
				System.out.println(placeId);
				
				//Update Place
				String newAddress="summer walk,Afrika";
				given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"place_id\": \""+placeId+"\",\r\n"
						+ "    \"address\": \""+newAddress+"\",\r\n"
						+ "    \"key\": \"qaclick123\"\r\n"
						+ "}")  
				.when().put("maps/api/place/update/json") //use put method to update the address
				.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated")); //verify the update msg   
				
				//get method
				String getPlaceRespoonce=given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json")
				.then().assertThat().statusCode(200).extract().response().asString();  //Extract the responce in String format
				//.then().assertThat().statusCode(200).body("address",equalTo(newAddress));// here we can verify the response 
				//JsonPath j=new JsonPath(getPlaceRespoonce);// to convert the response string into Json
				JsonPath j=new JsonPath(getPlaceRespoonce);//call JsonPath Object
				String actualAddress=j.getString("address");// get address in string format
				System.out.println(actualAddress);
				Assert.assertEquals(actualAddress, newAddress,"Test Fail");		
	}
}
