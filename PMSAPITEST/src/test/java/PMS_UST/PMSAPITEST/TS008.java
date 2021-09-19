package PMS_UST.PMSAPITEST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;

public class TS008 {

	public static void main(String[] args) 
	{
	

		RestAssured.baseURI="http://localhost:8080/";
		given().header("Content-Type","application/json").body("{\r\n"
				+ "     \"pNAME\":\"NON-VegSupreme\",\r\n"
				+ "     \"pPRICE\":\"700\"\r\n"
				+ "}").when().post("addpizza").then().log().all().assertThat().statusCode(201)
		.header("unique", containsString("NON-VegSupreme")).body("msg", equalTo("Success : Employee is Already Exist"));
		
		
	}
	
		
	}
	
	
