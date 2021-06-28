package com.parkmeright.proj.services;


public enum ParkingConstants 
{
	
		 PARKING_RATE_24HOURS(10.0), 
		 PARKING_SLOTS_24HOURS(4.0),
		 PARKING_HOURS_PER_SLOT(6.0);
		 
		 private Double const_value;
		 
		 ParkingConstants (Double value)
		 {
			 this.const_value = value;
		 }
		 public Double getValue() 
		 {
			 return this.const_value;
		 }
		 
	 

}
