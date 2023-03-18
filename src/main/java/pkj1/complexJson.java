package pkj1;

import io.restassured.path.json.JsonPath;
import payload.payload;

public class complexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js= new JsonPath(payload.CoursePrice());   //mocke Json ->means if we dont have url that time we do mock to check the json response
		int count=js.getInt("course.size()");  //get no of courses returned by API
		System.out.println(count);
		
		int totalAmount=js.getInt("dashboard.purchaseAmount");  //to get purchaseAmount,  //getInt() use to get int value
		System.out.println(totalAmount);
		 
		String titleFristCource=js.get("course[2].title");  //To get title from array  //get() use to get String
		System.out.println(titleFristCource);
		
		//Print All cources titles and their respective Prices
		
		for(int i=0;i<count;i++) {
			String coursetitles=js.get("course["+i+"].title");
			System.out.println(js.get("course["+i+"].price").toString());
			System.out.println(coursetitles);
		}	
		
	}

}
