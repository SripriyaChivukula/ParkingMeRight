package com.parkmeright.proj.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Zones 
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long zoneid;
   private Integer zonenumber;
   private int siteid;
   private Integer numoflots;
   private String amenities;
   private String city;
   private String state;
   private Integer zipcode;
  
  
 //  @OneToMany
 //  private List<ParkingLot> parkingLotlist;
   
   public Zones() 
   {
		super();
	}
   


public Zones(Integer zonenumber, int i, Integer numoflots, String amenities, String city,
		String state, Integer zipcode) 
{
	super();
	//this.zoneid = zoneid;
	this.zonenumber = zonenumber;
	this.siteid = i;
	this.numoflots = numoflots;
	this.amenities = amenities;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
	
}



public Long getZoneid() {
	return zoneid;
}
public void setZoneid(Long zoneid) {
	this.zoneid = zoneid;
}
public int getSiteid() {
	return siteid;
}
public void setSiteid(int siteid) {
	this.siteid = siteid;
}
public Integer getNumoflots() {
	return numoflots;
}
public void setNumoflots(Integer numoflots) {
	this.numoflots = numoflots;
}
public String getAmenities() {
	return amenities;
}
public void setAmenities(String amenities) {
	this.amenities = amenities;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Integer getZipcode() {
	return zipcode;
}
public void setZipcode(Integer zipcode) {
	this.zipcode = zipcode;
}
public Integer getZonenumber() {
	return zonenumber;
}
public void setZonenumber(Integer zonenumber) {
	this.zonenumber = zonenumber;
}
/*public List<ParkingLot> getParkingLotlist() {
	return parkingLotlist;
}
public void setParkingLotlist(List<ParkingLot> parkingLotlist) {
	this.parkingLotlist = parkingLotlist;
}*/



}
