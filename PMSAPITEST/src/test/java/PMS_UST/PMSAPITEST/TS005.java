package PMS_UST.PMSAPITEST;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class TS005 {
	public static void main (String[] args) {
		
		
		

	
		//Using Query Parameter
		
			/*	System.out.println("----------------------------------------------");
				RestAssured.baseURI="http://localhost:8080/";
				given().when().get("getPizza?Product=Veggie").then().log().body();
				System.out.println("----------------------------------------------");
				
				System.out.println("----------------------------------------------");
				//RestAssured.baseURI="http://localhost:8080/";
				given().when().get("getpizza/Veggie9").then().log().body();
				System.out.println("----------------------------------------------");
				*/
				

				//Using Query Parameter
				
				System.out.println("----------------------------------------------");
				RestAssured.baseURI="http://localhost:8080/";
				given().queryParam("Product", "Non-Veggie").when().get("getPizza").then().log().body();
				
	}
	
				
	}
	