package com.Api23testing;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class SimpleApi {
  @Test
	public void getRequestActivity() {
		
		RequestSpecification request =RestAssured.given();
		Response rs= request.given().get("https://fakerestapi.azurewebsites.net/api/v1/activities");
		rs.then().contentType(ContentType.JSON).statusCode(200);//.time(Matchers.lessThan(5000L));
		System.out.print(rs.statusCode());
		
	}
  
}
