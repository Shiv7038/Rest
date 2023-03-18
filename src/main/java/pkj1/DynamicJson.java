package pkj1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import payload.payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
 //Dynamic Json
	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.AddBook("shiv","22pf70"))   // AddBook() take isbn,aisle this tow string
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String id= js.get("ID");
		System.out.println(id);
	}
	
	//parameterization in Test
	@Test(dataProvider= "BooksData")
	public void addBook1(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.AddBook(isbn,aisle))   // AddBook() take isbn,aisle this tow string
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String id= js.get("ID");
		System.out.println(id);
	}
    // use DataProvider 
	@DataProvider(name="BooksData")
	public String[][] gateData() {
		String data[][]={{"jfdlkjsj","2fghp70"},{"jsjfkj","22rfgf70"}};
		return data;
	}
	
	@Test
	public void addBookFileData() {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.AddBook("shiv","22pf70"))   // AddBook() take isbn,aisle this tow string
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		String id= js.get("ID");
		System.out.println(id);
	}
}
