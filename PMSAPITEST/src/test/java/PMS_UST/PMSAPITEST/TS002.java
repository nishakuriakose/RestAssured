package PMS_UST.PMSAPITEST;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class TS002 {
	
public static void main (String[] args) {
		
		
		
		
		System.out.println("----------------------------------");
		RestAssured.baseURI="http://localhost:8080";
		//when for submission
		given().when().get("/getpizza/Veggie8").then().log().body();
		
		//given().get("http://localhost:8080/getpizza/Veggie8").then().log().body();//not a right way to do in application
		System.out.println("----------------------------------");
	}

}
