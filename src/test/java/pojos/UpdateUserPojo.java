package pojos;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountno",
"departmentno",
"salary",
"pincode",
"userid",
"id"
})
//enerated("jsonschema2pojo")
public class UpdateUserPojo {

@JsonProperty("accountno")
private String accountno;
@JsonProperty("departmentno")
private String departmentno;
@JsonProperty("salary")
private String salary;
@JsonProperty("pincode")
private String pincode;
@JsonProperty("userid")
private String userid;
@JsonProperty("id")
private String id;
@JsonProperty("userid")
public String getUserid() {
return userid;
}

@JsonProperty("userid")
public void setUserid(String userid) {
this.userid = userid;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;}

@JsonProperty("accountno")
public String getAccountno() {
return accountno;
}

@JsonProperty("accountno")
public void setAccountno(String accountno) {
this.accountno = accountno;}

@JsonProperty("departmentno")
public String getDepartmentno() {
return departmentno;
}
@JsonProperty("departmentno")
public void setDepartmentno(String accountno) {
this.departmentno = departmentno;}


@JsonProperty("salary")
public void setSalary(String salary) {
this.salary = salary;}

@JsonProperty("salary")
public String getSalary() {
return salary;
}

@JsonProperty("pincode")
public void setPincode(String pincode) {
this.pincode = pincode;}

@JsonProperty("pincode")
public String getPincode() {
return pincode;
}

}

