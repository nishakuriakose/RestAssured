package PMS_UST.PMSAPITEST;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;


public class TS011 {
	
	
	public static String response;
	public static String vID;
	public static String vMSG;

	public static void main(String[] args) throws InterruptedException 
	{

		RestAssured.baseURI="http://localhost:8080/";
		
		CREATE_CRUD();
		Thread.sleep(5000);
		GET_CRUD();
		Thread.sleep(5000);
		UPDATE_CRUD();
		Thread.sleep(15000);
		DELETE_CRUD();
		Thread.sleep(5000);
		
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
		
		
	}

	
	public static void GET_CRUD()
	{
		System.out.println("--------------------------------------");
		response=given().when().get("getpizza/"+vID).then().log().all().extract().response().asString();
		JsonPath jpath=new JsonPath(response);
		Assert.assertEquals(vID, jpath.getString("pID"));
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
	
	
	
	public static void UPDATE_CRUD()
	{
		System.out.println("--------------------------------------");
		given().header("Content-Type","application/json").body(updatePizaa())
		.when().put("updatePizza/"+vID)
		.then().log().body();
		System.out.println("--------------------------------------");
	}
	
	
	
	public static String updatePizaa()
	{
		
		return "{\r\n"
				+ "    \"pNAME\": \"NonVeggie1\",\r\n"
				+ "    \"pPRICE\": \"1000\"\r\n"
				+ "}";
	}

	public static void DELETE_CRUD()
	{
		System.out.println("--------------------------------------");
		given().header("Content-Type","application/json").body(deletepizza())
		.when().delete("deletepizza")
		.then().log().body().log();
		System.out.println("--------------------------------------");
	}


public static String deletepizza()
{
	return "{\r\n"
			+ "    \"pID\":\""+vID+"\"\r\n"
			+ "}";
}

}

