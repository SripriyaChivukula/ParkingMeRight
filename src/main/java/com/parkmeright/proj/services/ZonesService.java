package com.parkmeright.proj.services;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Payments;
import com.parkmeright.proj.entity.Timeslot;
import com.parkmeright.proj.entity.Zones;
import com.parkmeright.proj.repository.ParkingLotRepository;
import com.parkmeright.proj.repository.PaymentsRepository;
import com.parkmeright.proj.repository.TimeSlotRepository;
import com.parkmeright.proj.repository.ZonesRepository;



@Service
public class ZonesService 
{
	
	 private ZonesRepository repo;
	 private ParkingLotRepository prepo;
	 private TimeSlotRepository trepo;
	 private PaymentsRepository pyrepo;
    @Autowired
	public ZonesService(ZonesRepository repo, ParkingLotRepository prepo,TimeSlotRepository trepo,PaymentsRepository pyrepo) 
	    {
	    	this.repo = repo;
	    	this.prepo = prepo;
	    	this.trepo=trepo;
	    	this.pyrepo=pyrepo;
	    }
	ParkingConstants park;
	@Transactional
	public void insertIntoZonesParkingLots()
	{
	
		List<ParkingLot> p = new ArrayList<ParkingLot>();
		p=prepo.findAll();
		List<Zones> z1 =  repo.findByZonenumber(1);
		for(Zones z:z1)
		{
//			z.setParkingLotlist(p);
		}
		
	//	Zones z2 = (Zones) repo.findByZonenumber(2);
	//	z1.setParkingLotlist(plist1);
		
	//	Zones z3 = (Zones) repo.findByZonenumber(3);
	//	z1.setParkingLotlist(plist2);*/
		
	}
	 @Transactional
	  public void update(Zones z) 
	 {
	    //	List<ParkingLot>  p = (List<ParkingLot>) prepo.findAll();
	    //	z.setParkingLotlist(p);
	    	
	    }
	   public List<ParkingLot> listAll()
		{
			return (List<ParkingLot>) prepo.findAll();
		}
	  @Transactional
	  public void addParkingLots()
	   {
		 ParkingLot p0=new ParkingLot(1,true);
		 prepo.save(p0);
		 ParkingLot p = new ParkingLot(2,true);
		 prepo.save(p);
		 ParkingLot p1=new ParkingLot(3,true);
		 prepo.save(p1);
		 ParkingLot p2=new ParkingLot(4,true);
		 prepo.save(p2);
		 ParkingLot p3 =new ParkingLot(5,true);
		 prepo.save(p3);
		// List<ParkingLot> plist = prepo.findAll();
		 Zones z = new Zones(1,1,5,"abc","SanFrancisco","TX",27141);
		 repo.save(z);
	    Zones z1=new Zones(2,2,5,"efg","New york","NY",18121);
		 repo.save(z1);
	     Zones z2 = new Zones(3,3,5,"hij","Princeton","NJ",18536);
    	 repo.save(z2);
    	    
    	Date date = Calendar.getInstance().getTime();  
 		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 	
 		String strDate = dateFormat.format(date);  
 		Integer i = 24-Calendar.getInstance().getTime().getHours();
 		
 		
 		 Integer bookinghoursorder = i; 
 		 System.out.println(i);
 		// System.out.println(bookinghoursorder);
		 Double price = park.PARKING_RATE_24HOURS.getValue() ;
		 Double totalwithtax=0.0;
		price = Math.ceil(((bookinghoursorder)/park.PARKING_HOURS_PER_SLOT.getValue()))*(price/park.PARKING_SLOTS_24HOURS.getValue());

    	  
 		  Timeslot ts = new Timeslot(i,strDate,price);
  	      trepo.save(ts);
  	      Payments py = new Payments("Visa,Paypal,ApplePay",0.05,0.00);
  	      pyrepo.save(py);
  	      
  	      //Create the following mysql event to reset parking lot availability every day
  	      //create EVENT  `reservation_reset` ON SCHEDULE EVERY 1 DAY STARTS '2021-01-01 00:00:00' DO UPDATE parking_lot SET availability=1 ;
  	      
  	      
  	      
//		 Zones z3 = new Zones(4,4,5,"klm","Austin","TX",78732,plist);*/
	     
//		 repo.save(z3);
	  //   Zones zone = repo.findById(zoneid).get();
	//	ParkingLot plot = prepo.findById(parkinglotid).get();
	//		zone.setParkingLotlist(plot);
   /*    List<ParkingLot> plist = prepo.findAll();
       Zones z = repo.findByZonenumber(1).get(0);
      
 	   for(ParkingLot pl:plist)
 	    {
 		   
 	    	pl.setZone(z);
 	    	System.out.println(pl.getZone().getZonenumber());
 	    	System.out.println(pl.getParkinglotid());
 	    	System.out.println(pl.getParkinglotnum());
 	    }
		  
		   
	   }*/
	   }
	  
	  public List<Zones> findByZonenumberService(Integer zonenum)
	  {
		 
		  List<Zones> z= repo.findByZonenumber(zonenum);
		  
		  
		  return z;
		  
	  }
	 
	  public List<Zones> findByCityService(String city)
	  {
		  System.out.println("Im in finbycityservice"+city);
		  List<Zones> z= repo.findByCity(city);
		  for(Zones z1:z)
		  {
			  System.out.println(z1.getCity());
			  System.out.println(z1.getState());
		  }
		  return z;
	  }
	 
	//public zones getByZonenumber(Integer zonenum)
	{
    //	return repo.findByZonenumber(zonenum);
    }
	
	
}
