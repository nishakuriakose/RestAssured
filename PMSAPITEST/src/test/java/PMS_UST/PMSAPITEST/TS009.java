package PMS_UST.PMSAPITEST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


import io.restassured.RestAssured;

public class TS009 {


	public static void main(String[] args) 
	{
	
		
		RestAssured.baseURI="http://localhost:8080/";
		given().header("Content-Type","application/json").body( addPizzaPayLoad())
		.when().post("addpizza").then().log().all().assertThat().statusCode(201)
		.header("unique", containsString("Veggie")).body("msg", equalTo(" Success : Pizza is added"));
		
		
	}
	
	
	public static String addPizzaPayLoad()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"pNAME\" :\"Veggie\",\r\n"
				+ "\"pPRICE\" :\"500\"\r\n"
				+ "}";
	}
	

}
