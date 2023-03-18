package pkj1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payload.payload;

public class sumValidation {

 @ Test 
 public void sumOfcourses() {
	 int sum=0;
	 JsonPath js= new JsonPath(payload.CoursePrice());   //mocke Json ->means if we dont have url that time we do mock to check the json response
		int count=js.getInt("course.size()"); //get size of courses
		
		for(int i=0;i<count;i++) {
			int price=js.getInt("course["+i+"].price"); // get price 
			int copies=js.getInt("course["+i+"].copies"); //get copies
			int amount=price*copies;   //multiplly price and copies to check purchaseAmount 
			sum=sum+amount;
 }
		System.out.println(sum);
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");// get purchaseAmount
		System.out.println(purchaseAmount);
		Assert.assertEquals(sum, purchaseAmount);
 }}

