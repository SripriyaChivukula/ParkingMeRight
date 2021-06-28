package com.parkmeright.proj.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ParkingLot 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parkinglotid;
	private Integer parkinglotnum;
	private boolean availability;
	
	@ManyToOne
	private Timeslot timeslot;
    @ManyToOne
    private Zones zone;
    @ManyToOne
    private Payments payment;
    
    @OneToOne
    private Customer customer;
	
	public ParkingLot() 
	{
		super();
	}
	
	
	


	public ParkingLot(Integer parkinglotnum, boolean availability) 
	{
		super();
//		this.parkinglotid = parkinglotid;
		this.parkinglotnum = parkinglotnum;
		this.availability = availability;
	}





	public Integer getParkinglotid() {
		return parkinglotid;
	}


	public void setParkinglotid(Integer parkinglotid) {
		this.parkinglotid = parkinglotid;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public Integer getParkinglotnum() {
		return parkinglotnum;
	}


	public void setParkinglotnum(Integer parkinglotnum) {
		this.parkinglotnum = parkinglotnum;
	}


	public Timeslot getTimeslot() {
		return timeslot;
	}


	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}





	public Zones getZone() {
		return zone;
	}





	public void setZone(Zones zone) {
		this.zone = zone;
	}





	public Payments getPayment() {
		return payment;
	}





	public void setPayment(Payments payment) {
		this.payment = payment;
	}





	public Customer getCustomer() {
		return customer;
	}





	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	
}
