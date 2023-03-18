package pkj1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetJsonFromFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(m1()).when()
				.post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)");

	}

	public static String m1() throws Exception {

		String fileName = "C:\\\\Users\\\\spawar6\\\\eclipse-workspace\\\\RestAssured1\\\\src\\\\main\\\\resources\\\\Files\\\\BookJson.json";
		FileInputStream inputStream = new FileInputStream(new File(fileName));

		byte[] buffer = new byte[1024];
		int bytesRead;
		StringBuilder stringBuilder = new StringBuilder();

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			stringBuilder.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
		}

		String fileContent = stringBuilder.toString();

		return fileContent;
	}
}
