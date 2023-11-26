package com.Api23testing;




import org.testng.annotations.Test;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import pojos.AddUserPojo;
//import pojos.UpdateUserPojo;
import pojos.AddUserPojo;
import pojos.UpdateUserPojo;
 
public class TechArchApiTest {
static String token1;
static String userid1;
static String id1;
static String deprtNumber;
public static String UsertoAdd="{\"accountno\":\"TA-2222000\",\"departmentno\":\"9\",\"salary\":\"345\",\"pincode\":\"456789\"}";
static String updateUser;
static String useidNid;
AddUserPojo addpojObj;;
UpdateUserPojo updatepojoObj;
@Test
public String loginTest()
{
RequestSpecification resp= RestAssured.given().log().all().contentType(ContentType.JSON);
Response res=  resp.body("{\"username\":\"chitraemail22@ta.com\",\"password\":\"chitra@123\"}")
 .when().post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
 res.prettyPrint();
 token1= res.jsonPath().get("[0].token");
System.out.println("token is="+token1);
res.then().log().all();
return token1;
}
@Test(priority = 2)
public void getUser()
{  if(token1==null)
loginTest();
Header header1=new Header("token",token1);
   Response res= RestAssured.given().header(header1)
.when().get("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata");
   //res.then().body(matchesJsonSchemaInClasspath("getUserDataalidation.json"));
    String accNum= res.jsonPath().get("[0].accountno");
    userid1= res.jsonPath().get("[0].userid");
    System.out.println("user id is="+userid1);
    id1= res.jsonPath().get("[0].id");
    System.out.println(" id is="+id1);
    System.out.println(userid1);
    System.out.println("total number of record"+ res.jsonPath().get("body.size()"));
     System.out.println("firs set of Acc number is"+ accNum);
}
@Test(priority =2 ,enabled=false)
public void createuser()
{
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
Response res= RestAssured.given().header(header1).contentType(ContentType.JSON)
.body(UsertoAdd)

.when().post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData");
System.out.println(UsertoAdd);
System.out.println(deprtNumber);
System.out.println();
  System.out.println("status is="+res.jsonPath().get("status"));
 

}
@Test (priority=1)
public void createuserWithPojo()
{
if(token1==null)
loginTest();
addpojObj=new AddUserPojo();
addpojObj.setAccountno("TA-2222008");
addpojObj.setDepartmentno("9");
addpojObj.setSalary("345");
addpojObj.setPincode("456789");
Header header1=new Header("token",token1);
  Response res= RestAssured.given().header(header1).contentType(ContentType.JSON)
.body(addpojObj)

.when().post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData");
System.out.println(addpojObj);
System.out.println(deprtNumber);
System.out.println();
  System.out.println("status is="+res.jsonPath().get("status"));
 

}
//JsonPath.with(jsonResponse).get("findAll { a -> a.name == 'getName' }");
public void updateUserWithFindAll()
{ System.out.println("token in updateuser is=="+token1);
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
//updatepojoObj=new UpdateUserPojo();
String accNumForUpdate=addpojObj.getAccountno();
//JsonPath.with(jsonResponse).get("findAll { a -> a.name == 'getName' }");
//JsonPath.with(jsonResponse).param("name", "getName").get("findAll { a -> a.name == name  }")
//JsonPath.w
updatepojoObj.setAccountno(accNumForUpdate);
updatepojoObj.setDepartmentno("7");
updatepojoObj.setSalary(addpojObj.getSalary());
updatepojoObj.setPincode(addpojObj.getPincode());
updatepojoObj.setUserid(userid1);
updatepojoObj.setId(id1);
System.out.println("accNumForUpdate"+accNumForUpdate);



  Response res= RestAssured.given().header(header1).contentType(ContentType.JSON).body(updatepojoObj).when().
put("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData");
  System.out.println(updatepojoObj.getUserid());
System.out.println("status is="+res.jsonPath().get("status"));


}
@Test(priority=3)
public void updateUserWithPojo()
{ System.out.println("token in updateuser is=="+token1);
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
updatepojoObj=new UpdateUserPojo();
String accNumForUpdate=addpojObj.getAccountno();
updatepojoObj.setAccountno(accNumForUpdate);
updatepojoObj.setDepartmentno("7");
updatepojoObj.setSalary(addpojObj.getSalary());
updatepojoObj.setPincode(addpojObj.getPincode());
updatepojoObj.setUserid(userid1);
updatepojoObj.setId(id1);
System.out.println("accNumForUpdate"+accNumForUpdate);



  Response res= RestAssured.given().header(header1).contentType(ContentType.JSON).body(updatepojoObj).when().
put("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData");
  System.out.println(updatepojoObj.getUserid());
System.out.println("status is="+res.jsonPath().get("status"));


}


@Test(priority=3 , enabled=false)
public void updateUser()
{ System.out.println("token in updateuser is=="+token1);
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
deprtNumber="4";
updateUser="{\"accountno\":\"TA-9876543\",\"departmentno\":\""
+ deprtNumber
+ "\",\"salary\":\"777\",\"pincode\":\"888888\",\"userid\":\""
+ userid1+
"\",\"id\":\""
+ id1+
"\"}";

  Response res= RestAssured.given().header(header1).contentType(ContentType.JSON).body(updateUser).when().
put("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData");
  System.out.println(updateUser);
System.out.println("status is="+res.jsonPath().get("status"));


}
@Test(priority=4)
public void deleteUser()
{
System.out.println("token in updateuser is=="+token1);
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
useidNid="{\"id\":\""+id1+"\",\"userid\":\""+userid1+"\"}";
System.out.println("delete string for body is="+useidNid);
Response res= RestAssured.given().header(header1).contentType(ContentType.JSON).body(useidNid).when()
.delete("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/deleteData");
System.out.println("status is="+res.jsonPath().get("status"));

}
// @Test
public void deleteUserwithPojo()
{
System.out.println("token in updateuser is=="+token1);
if(token1==null)
loginTest();
Header header1=new Header("token",token1);
//updatepojoObj.setUserid(userid1);
//updatepojoObj.setId(id1);
useidNid="{\"id\":\""+id1+"\",\"userid\":\""+userid1+"\"}";
Response res= RestAssured.given().header(header1).contentType(ContentType.JSON).body(useidNid).when().
delete("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/deleteData");
System.out.println("status is="+res.jsonPath().get("status"));

}


}


