package PMS_UST.PMSAPITEST;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;


public class TS010 {
	
	
	public static String response;
	public static String vID;
	public static String vMSG;

	public static void main(String[] args) throws InterruptedException 
	{

		RestAssured.baseURI="http://localhost:8080/";
		
		CREATE_CRUD();
		Thread.sleep(5000);
		GET_CRUD();
	}
	
	
	public static void CREATE_CRUD()
	{
		System.out.println("--------------------------------------");
			
		response=given().header("Content-Type","application/json").header("Connection","keep-alive").body(AddPizzaPayLoad())
		.when().post("addpizza")
		.then().assertThat().statusCode(201).header("unique", containsString("Veggie")).extract().response().asString();
		
		
		System.out.println(response);
		System.out.println("--------------------------------------");
		
		JsonPath jpath=new JsonPath(response);
		vID=jpath.getString("id");
		vMSG=jpath.getString("msg");
		
		System.out.println("ID is "+vID);
		System.out.println("Message is "+vMSG);
		
		// JavaScript Object Notation
		// Why do we use --> For Transfering the data
		// What is the alternate --> XML
		
		//What is Modular Framework?
				//Creating methods for each test
				
				
				//What is Data Driven Frameowrk?
				//Executing a script with multiple set of data
				//Data wil be separate and your script will be separate
				
				
				//What is Keyword Framework
				//HyBrid Framework = Keyword + Data Driven Frameowrk
				
				
		
	}

	
	public static void GET_CRUD()
	{
		System.out.println("--------------------------------------");
		response=given().when().get("getpizza/"+vID).then().log().all().extract().response().asString();
		JsonPath jpath=new JsonPath(response);
		Assert.assertEquals(vID, jpath.getString("eID"));
		System.out.println("--------------------------------------");
	}
	
	
	public static String AddPizzaPayLoad()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"pNAME\" :\"Veggie\",\r\n"
				+ "\"pPRICE\" :\"500\"\r\n"
				+ "}";
	}
	

}
