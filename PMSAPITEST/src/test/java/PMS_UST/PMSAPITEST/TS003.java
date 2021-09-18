package PMS_UST.PMSAPITEST;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class TS003 {
	public static void main (String[] args) {
		
		
		

	
	//Using Query Parameter
	
			System.out.println("----------------------------------------------");
			RestAssured.baseURI="http://localhost:8080/";
			given().when().get("getPizza?Product=Veggie").then().log().body();
			System.out.println("----------------------------------------------");
	}		
}
