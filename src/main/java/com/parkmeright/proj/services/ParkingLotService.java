package com.parkmeright.proj.services;

import java.text.DateFormat;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkmeright.proj.entity.Customer;
import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Payments;
import com.parkmeright.proj.entity.Timeslot;
import com.parkmeright.proj.entity.Zones;
import com.parkmeright.proj.repository.ParkingLotRepository;
import com.parkmeright.proj.repository.PaymentsRepository;
import com.parkmeright.proj.repository.TimeSlotRepository;
import com.parkmeright.proj.repository.ZonesRepository;



@Service
public class ParkingLotService 
{
    
	 private ZonesRepository repo;
	 private ParkingLotRepository prepo;
	 private TimeSlotRepository trepo;
	 private PaymentsRepository pyrepo;

	 @Autowired
	public ParkingLotService(ZonesRepository repo, ParkingLotRepository prepo,TimeSlotRepository trepo,PaymentsRepository pyrepo) 
	    {
	    	this.repo = repo;
	    	this.prepo = prepo;
	    	this.trepo = trepo;
	    	this.pyrepo=pyrepo;
	    }

	   ParkingConstants park;
	   
	@Transactional
	public List<ParkingLot> getParkingLotsByZonenumber(Integer zonenum)
	
	{  
		   Zones z = repo.findByZonenumber(zonenum).get(0);
		   Timeslot t = trepo.findAll().get(0);
	//	   System.out.println(repo.findByZonenumber(zonenum).get(0));
	        ParkingLot p = new ParkingLot();
	      //  p.setZone(z);
		//    p.setTimeslot(t);
		   
		   List<ParkingLot> plist = prepo.findAll();
	       for(ParkingLot pl:plist)
	 	    {
	 		   
	 	      pl.setZone(z);
	 	      pl.setTimeslot(t);
	 	  
	 	    }
	       return plist;
			  	
	 
	
	
	}
	public List<ParkingLot> getParkingLotsByAvailability(Boolean availabilty,Integer parkinglotnumber)
	{    availabilty=true;
		 ParkingLot p = new ParkingLot();
		 List<ParkingLot> plist = prepo.findByAvailabilityAndParkinglotid(availabilty,parkinglotnumber);
		 return plist;
	}
	
	
	@Transactional
	public List<ParkingLot> updateParkingLotAvailability(Integer parkinglotid,Integer zonenumber,Boolean availability)
	{
		
		   
	  	     
	  	     
		 Zones z = repo.findByZonenumber(zonenumber).get(0); 
		 
		 ParkingLot p = new ParkingLot();
		 Payments py = new Payments();
		 py=pyrepo.findAll().get(0);
		 
		    
		// p.setAvailability(false);
		 List<ParkingLot> plist = prepo.findByParkinglotid(parkinglotid);
		 for(ParkingLot pl:plist)
		 {
			 pl.setZone(z);
			 pl.setPayment(py);
			 pl.setAvailability(availability);
			 System.out.println(pl.getPayment().getPaymenttype());
			 
			 
			 Integer numofhours=pl.getTimeslot().getBookinghours();
			 Integer bookinghoursorder = numofhours;
			 
			 
			 Double price = park.PARKING_RATE_24HOURS.getValue() ;
			 Double totalwithtax=0.0;
			 
			    Date date = Calendar.getInstance().getTime();  
		 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 	
		 		String strDate = dateFormat.format(date);  
		 		Integer i = 24-Calendar.getInstance().getTime().getHours();
		    	  
		 		  Timeslot ts = new Timeslot(i,strDate,price);
		  	      List<Timeslot> t =trepo.findAll();
		  	     
		  	      for(Timeslot tl:t)
		  	      {
		  	      tl.setPricing(price);	  
		  	      tl.setBookingdate(strDate);
		  	      tl.setBookinghours(i);
		  	      trepo.save(tl);
		  	      }
			 
			 price = Math.ceil(((bookinghoursorder)/park.PARKING_HOURS_PER_SLOT.getValue()))*(price/park.PARKING_SLOTS_24HOURS.getValue());
			 totalwithtax = pl.getPayment().getTax();
			 pl.getPayment().setTotal(price+totalwithtax);
			 pl.getTimeslot().setPricing(price);
			 
			 /*
			 if(numofhours/4==0)
			 {
			    price=pl.getTimeslot().getPricing(); 
				price=price/1;
				System.out.println(price+"hellohello");
			    totalwithtax = pl.getPayment().getTax();
			    System.out.println(totalwithtax+"hellohello");
				pl.getPayment().setTotal(price+totalwithtax);
				pl.getTimeslot().setPricing(price);
			 }
			 else if(numofhours/4==1)
			 {
				    price=pl.getTimeslot().getPricing(); 
				    price = price/2;
					totalwithtax = pl.getPayment().getTax();
					pl.getPayment().setTotal(price+totalwithtax);
					 pl.getTimeslot().setPricing(price);
				 
			 }
			 else if(numofhours/4==2)
			 {
				    price=pl.getTimeslot().getPricing(); 
				    price = price/3;
					totalwithtax = pl.getPayment().getTax();
					pl.getPayment().setTotal(price+totalwithtax);
					 pl.getTimeslot().setPricing(price);
					
			 }
			 
			 else 
			 {
				    price=pl.getTimeslot().getPricing(); 
				    price = price/4;
				    System.out.println(price+"hellohello");
				    totalwithtax = pl.getPayment().getTax();
				    System.out.println(totalwithtax+"hellohello");
					pl.getPayment().setTotal(price+totalwithtax);
					 pl.getTimeslot().setPricing(price);
			 }
			 */
			 
			// System.out.println(pl.isAvailability());
			
		//	 Integer reservationidcalc = (int) ((pl.getPayment().getReservationid())*Math.random());
		//	 System.out.println(reservationidcalc);
		//	 pl.getPayment().setReservationid(reservationidcalc);
			 
			 
			
		 
		 }
	     return plist;
		
	}
	
	
	
	
	public void getParkingLotsByAvailabilityByZonenumber(Boolean availabilty,Integer parkinglotnumber)
	{
		 ParkingLot p = new ParkingLot();
		 List<ParkingLot> plist = prepo.findByAvailabilityAndParkinglotid(availabilty,parkinglotnumber);
	}
	
	public List<ParkingLot> getParkingLotsByCity(String city)
	{
		 Zones z = repo.findByCity(city).get(0); 
		 ParkingLot p = new ParkingLot();
	     p.setZone(z);
	     List<ParkingLot> plist = prepo.findAll();
	   //  for(ParkingLot p1:plist)
	     {
	    //	 System.out.println(p1.getParkinglotnum());
	     }
		 return plist;
	}
	
	
	
	
	
	
	@Transactional
	public List<ParkingLot> updateParkingLotAvailabilityByCity(Integer parkinglotid,String city,Boolean availability)
	{
		
		
		
        Zones z = repo.findByCity(city).get(0); 
        
         //System.out.println("parameter"+city);
		 //System.out.println(z.getState()+"inside updateplbycity");
        
        
		 ParkingLot p = new ParkingLot();
		 Payments py = new Payments();
		 py=pyrepo.findAll().get(0);
	     //System.out.println(py.getReservationid());
		    
		// p.setAvailability(false);
		 List<ParkingLot> plist = prepo.findByParkinglotid(parkinglotid);
		 
		 
		 for(ParkingLot pl:plist)
		 {
			 pl.setZone(z);
			 pl.setPayment(py);
			 pl.setAvailability(availability);
			// System.out.println(pl.getPayment().getPaymenttype());
			 System.out.println(pl.getZone().getZipcode());
			 System.out.println(pl.getTimeslot().getTimeslotid());
			 Integer numofhours=pl.getTimeslot().getBookinghours();
			 System.out.println(numofhours);
			 Integer bookinghoursorder = numofhours;
			 
			 
			 Double price = park.PARKING_RATE_24HOURS.getValue() ;
			 Double totalwithtax=0.0;
			 
			    Date date = Calendar.getInstance().getTime();  
		 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 	
		 		String strDate = dateFormat.format(date);  
		 		Integer i = 24-Calendar.getInstance().getTime().getHours();
		    	  
		 		  Timeslot ts = new Timeslot(i,strDate,price);
		  	      List<Timeslot> t =trepo.findAll();
		  	     
		  	      for(Timeslot tl:t)
		  	      {
		  	      tl.setPricing(price);	  
		  	      tl.setBookingdate(strDate);
		  	      tl.setBookinghours(i);
		  	      trepo.save(tl);
		  	      }
			 
			 price = Math.ceil(((bookinghoursorder)/park.PARKING_HOURS_PER_SLOT.getValue()))*(price/park.PARKING_SLOTS_24HOURS.getValue());
			 totalwithtax = pl.getPayment().getTax();
			 System.out.println("price is:%f"+price);
			 pl.getPayment().setTotal(price+totalwithtax);
			 pl.getTimeslot().setPricing(price);
	 
	 
	 }
		 for(ParkingLot pl:plist)
		 {
			 System.out.println("I'm in parkinglotservice reserve");
			 System.out.println(pl.getParkinglotid());
			 System.out.println(pl.getZone().getState());
			 System.out.println(pl.isAvailability());
		 }
	     return plist;
		
	}
	@Transactional
	public List<ParkingLot> saveCustomer(Customer actualcustomer,Integer pid,Integer r)
	
	{
		List<ParkingLot> pl =prepo.findByParkinglotid(pid);
		
		//List<Payments> plist= pyrepo.findByReservationid(r);
		//System.out.println(actualcustomer.getFirstname());
		//System.out.println()
		for(ParkingLot p:pl)
		{
			
			p.setCustomer(actualcustomer);
			
			System.out.println(p.getCustomer().getLastname());
			
		
		}
		return pl;
	}
		@Transactional
		public List<ParkingLot> saveGuestCustomer(Customer actualcustomer,Integer pid)
		
		{
			List<ParkingLot> pl =prepo.findByParkinglotid(pid);
			
			//List<Payments> plist= pyrepo.findByReservationid(r);
			//System.out.println(actualcustomer.getFirstname());
			//System.out.println()
			for(ParkingLot p:pl)
			{
				
				p.setCustomer(actualcustomer);
				
				System.out.println(p.getCustomer().getLastname());
				
			
			}
		
		
//		System.out.println(pl.getCustomer().getUsername());
		return pl;
		
	}
		public boolean FindParkingLotAvailability(Integer pid, String c) 
		{
			Zones z = repo.findByCity(c).get(0);
			List<ParkingLot> p = prepo.findByParkinglotid(pid);
			Boolean availability = false;
			
			for(ParkingLot pl:p)
			{
				pl.setZone(z);
				
				availability=pl.isAvailability();
				
			}
			
			return availability;
		}
		
		
		public boolean FindParkingLotAvailabilityZoneNumber(Integer pid, Integer i) {
			Zones z = repo.findByZonenumber(i).get(0);
			List<ParkingLot> p = prepo.findByParkinglotid(pid);
			Boolean availability = false;
			
			for(ParkingLot pl:p)
			{
				pl.setZone(z);
				
				availability=pl.isAvailability();
				
			}
			
			return availability;
		}
	
	
	

}
