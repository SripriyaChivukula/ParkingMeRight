package com.parkmeright.proj.entity;

public class Vehicle 

{
	private Integer vehicleid;
	private String licenseplateid;
	private String  vehiclemake;
	private String vehiclemodel;
	private String vehicletype;
	
	public Vehicle()
	{
		super();
	}
	
	public Vehicle(Integer vehicleid, String licenseplateid, String vehiclemake, String vehiclemodel,
			String vehicletype) 
	{
		super();
		this.vehicleid = vehicleid;
		this.licenseplateid = licenseplateid;
		this.vehiclemake = vehiclemake;
		this.vehiclemodel = vehiclemodel;
		this.vehicletype = vehicletype;
	}

	public Integer getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getLicenseplateid() {
		return licenseplateid;
	}

	public void setLicenseplateid(String licenseplateid) {
		this.licenseplateid = licenseplateid;
	}

	public String getVehiclemake() {
		return vehiclemake;
	}

	public void setVehiclemake(String vehiclemake) {
		this.vehiclemake = vehiclemake;
	}

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	

}
