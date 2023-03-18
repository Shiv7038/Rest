package pkj1;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.payload;

public class ClassA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://lh3.googleusercontent.com";
		String response=given().header("Content-Type","application/json")
		   // AddBook() take isbn,aisle this tow string
		.when().get("/a-/AOh14GgGFWGNB3VrXgyr67Z0QYJVKywp5sBBhVMgCZli6ig=k-s32")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
//		JsonPath js=new JsonPath(response);
//		String id= js.get("ID");
//		System.out.println(id);
	}

}
