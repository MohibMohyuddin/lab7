import java.sql.*;
import java.util.*;
public class Person {

	private String name, fatherName, organization, mobile;
	private int id;
	
	public Person() {}
	public Person(int id, String name, String org, String fatherName, String mobile){
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		organization = org;
		this.mobile = mobile;
	}
	
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	public String getOrganization() {
		return organization;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getMobile() {
		return mobile;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
