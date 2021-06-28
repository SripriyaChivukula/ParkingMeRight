package com.parkmeright.proj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationid;
	private String paymenttype;
	private Double tax;
	private Double total;
	
	
	
	
	
	
	public Payments() {
		super();
	}


	public Payments(String paymenttype, Double tax, Double total) {
		super();
		
		this.paymenttype = paymenttype;
		this.tax = tax;
		this.total = total;
	}


	public Integer getReservationid() {
		return reservationid;
	}


	public void setReservationid(Integer reservationid) {
		this.reservationid = reservationid;
	}


	public String getPaymenttype() {
		return paymenttype;
	}


	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	

	
	
	

}
