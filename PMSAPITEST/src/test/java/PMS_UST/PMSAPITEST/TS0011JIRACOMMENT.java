package PMS_UST.PMSAPITEST;




import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;

public class TS0011JIRACOMMENT {

	//4tW1I4QolxAx7ZUg9wV6D7A2
	public static String Username="nisha.kuriakose@gmail.com";
	public static String Password="4tW1I4QolxAx7ZUg9wV6D7A2";
	
	
	public static void main(String[] args) 
	{
	
		//STEP01: Create a JIRA Issue Tracking Project
		//STEP02: Create Access Token (stRwzZPBUsdEpoFW2kKj2CF7) 
		//https://usttest.atlassian.net/jira/software/c/projects/NA/issues/?filter=allissues
		
		RestAssured.baseURI="https://usttest.atlassian.net/";
		given().auth().preemptive().basic(Username, Password).header("Content-Type","application/json").body(addComment())
		.when().post("rest/api/2/issue/NA-1/comment").then().log().all().assertThat().statusCode(201);
		
	 
	}
	
	//Add the Payload Details
	//public static String AddJIRAIssue()
/*	{
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"NA\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"REST ye merry gentlemen.\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}";
	}*/

public static String addComment()
	 {
	  return "{\r\n"
	    + "    \"body\": \"This is a comment regarding the quality of the response.\"\r\n"
	    + "}";
	 }

	

}
