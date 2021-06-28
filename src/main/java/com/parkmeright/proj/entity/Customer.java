package com.parkmeright.proj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custid;
	@Size(min=2, max=10, message="Firstname is required and must be between 2 and 10 characters")
	private String firstname;
	@Size(min=2, max=10, message="Lastname is required and must be between 2 and 10 characters")
	private String lastname;
	@Size(min=2, max=50, message="address required and must be between 2 and 50 characters")
	private String address;
	@NotEmpty
	private String email;
	
	
	private Long phonenum;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z0-9]+", message="User Name must contain only letters and numbers")
	private String username;
	@NotEmpty
	private String password;
	//private Integer numofbookings;
	private Integer rewardpoints;
	
	public Customer() 
	{
		super();
	}

	public Customer( String firstname, String lastname, String address, String email, Long phonenum,
			String username, String password, Integer rewardpoints) {
		super();
	//	this.custid = custid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.phonenum = phonenum;
		this.username = username;
		this.password = password;
	//	this.numofbookings = numofbookings;
		this.rewardpoints = rewardpoints;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(Long phonenum) {
		this.phonenum = phonenum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Integer getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(Integer rewardpoints) {
		this.rewardpoints = rewardpoints;
	}
	
	

}
