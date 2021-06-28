package com.parkmeright.proj.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Timeslot 
{   
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timeslotid; 
	
	private Integer bookinghours;
	private String bookingdate;
	private Double pricing;
   
   public Timeslot() 
   {
	super();
    }

   public Timeslot( Integer bookinghours, String bookingdate, Double pricing) 
   {
		super();
		
		this.bookinghours = bookinghours;
		this.bookingdate = bookingdate;
		this.pricing = pricing;
	}
   
   
   public Integer getTimeslotid() {
		return timeslotid;
	}

	public void setTimeslotid(Integer timeslotid) {
		this.timeslotid = timeslotid;
	}

	public Integer getBookinghours() {
		return bookinghours;
	}

	public void setBookinghours(Integer bookinghours) {
		this.bookinghours = bookinghours;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public Double getPricing() {
		return pricing;
	}

	public void setPricing(Double pricing) {
		this.pricing = pricing;
	}
}
