package com.parkmeright.proj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parkmeright.proj.entity.Customer;
import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Zones;
import com.parkmeright.proj.services.CustomerService;
import com.parkmeright.proj.services.ParkingLotService;
import com.parkmeright.proj.services.ZonesService;
import com.parmeright.proj.customexception.NullCustomException;
@Controller
public class ParkByCityController
{
	 @Autowired
	   private ZonesService zoneservice;
	   @Autowired
	   private ParkingLotService parkinglotservice;
	   @Autowired
	   private CustomerService customerservice;
	   private boolean alreadyexecutedcity=false;
	   
	   
	   @GetMapping("/parkbycity")
	
	   public String parkNowHome()
	   {
		 //  if(alreadyexecutedcity==false)
		   
			//   alreadyexecutedcity=true;
			//   zoneservice.addParkingLots();
		   
		 
		   return "parkbycity";
	   }
	 
	
	  @RequestMapping(value="/parkbycityresults",method=RequestMethod.POST)
	   public ModelAndView getParkingInfoByCity(@RequestParam("city") String s)
	   {
		  try
		  {
			 if(s=="NewYork"||s=="Princeton"||s=="SanFrancisco"||s==null)
			 {  		
		    
				 throw new NullCustomException("Currently Servin cities NewYork,Princeton,SanFrancisco");
			 } 
			 else
			 {
			     List<Zones> z = zoneservice.findByCityService(s);
		    
		        for(Zones z1:z)
		          {
		    	     System.out.println(z1.getCity());
		          }
		        	List<ParkingLot> p  = parkinglotservice.getParkingLotsByCity(s);
		  
		  
		        	ModelAndView mav = new ModelAndView("parkbycityresults"); 
		        	mav.addObject("parkinglistcity",p);
		        	mav.addObject("zoneitemlistcity",z);
		        	return mav;
			 }
		  }
		  catch(NullCustomException e)
		  {
			  ModelAndView mav = new ModelAndView("nullcustomexceptioncity"); 
			  return mav;
		  }
		  
	   }
/*	  @RequestMapping(value="/parkbycityresultsupdate",method=RequestMethod.GET)
	   public ModelAndView updateParkingAvailabilityByCity(@RequestParam("parkinglotid") Integer pid,@RequestParam("city")String c)
	   {
		  boolean p1=parkinglotservice.FindParkingLotAvailability(pid,c);
		  if( p1==true)
		  {
		
		  System.out.println("Hello I enterd parkingresults reserve");
		    List<Zones> z = zoneservice.findByCityService(c);
		    List<ParkingLot> p = parkinglotservice.updateParkingLotAvailabilityByCity(pid, c,p1);
		    for(Zones z1:z)
		    {
		    	System.out.println(z1.getCity());
		    	System.out.println("Im imside parkingcityresultsupdate");
		    }
		   
		   ModelAndView mav = new ModelAndView("parkbycityresults"); 
		   mav.addObject("parkinglistcity",p); 
		   mav.addObject("zoneitemlistcity",z);
		   return mav;
		  }
		  else
		  {
			  ModelAndView mav = new ModelAndView("availability"); 
			  return mav;
		  }
	   }*/
	   
	
	   
	   @RequestMapping(value="/parkbycityunreserve",method=RequestMethod.GET)
	   public ModelAndView unreserveParkingAvailabilityByCity(@RequestParam("parkinglotid") Integer pid,@RequestParam("city")String c,Boolean availability)
	   {
		   boolean p1=parkinglotservice.FindParkingLotAvailability(pid,c);
			  if( p1==false)
			  {
		    List<Zones> z = zoneservice.findByCityService(c);
		    List<ParkingLot> p = parkinglotservice.updateParkingLotAvailabilityByCity(pid, c,true);
		   
		   ModelAndView mav = new ModelAndView("parkbycityresults"); 
		   mav.addObject("parkinglistcity",p);
		   mav.addObject("zoneitemlistcity",z);
		   return mav;
			  }
			  else
			  {
				  ModelAndView mav = new ModelAndView("availability"); 
				  return mav;
				  
			  }
	   }
	  
	   
	   @RequestMapping(value="/parkbycitypay",method=RequestMethod.GET)
	   public ModelAndView PaymentsByCity(@RequestParam("city")String c,@RequestParam("parkinglotid") Integer pid,Boolean availability)
	   {
		   boolean p1=parkinglotservice.FindParkingLotAvailability(pid,c);
			  if( p1==true)
		{
		   List<Zones> z = zoneservice.findByCityService(c);
		   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailabilityByCity(pid, c,false);
		   ModelAndView mav = new ModelAndView("checkoutbycity");	   
		   mav.addObject("parkinglistcity",p);
		   mav.addObject("zoneitemlistcity",z);
		   return mav;
		}
			  else
			  {
				  ModelAndView mav = new ModelAndView("availability"); 
				  return mav;
			  }
	   }
	   @RequestMapping(value="/loginbycity",method=RequestMethod.GET)
	   public ModelAndView loginFormByCity(@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("city")String c,Model model)
	   {
		
		   
		   List<Zones> z = zoneservice.findByCityService(c);
		   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailabilityByCity(pid, c,false);
		   
		   ModelAndView mav = new ModelAndView("loginbycity");
		
		    mav.addObject("parkinglistcity",p);
		    mav.addObject("zoneitemlistcity",z);
		    System.out.println(r);
		    Integer reservationid= r;
		    Integer parkinglotid=pid;
		    System.out.println(pid);
		  
		   mav.addObject("reservationid",reservationid);
		   mav.addObject("parkinglotid",parkinglotid);
		
		   return mav;
		  
		  
	   }
	   
	   @ModelAttribute("customerkeycity")
	   public Customer setupCustomerByCity() 
	   {
	   	return new Customer();
	   }
	   
	  
	   @RequestMapping(value="/logincustomerinformationbycity",method=RequestMethod.GET)
	   public ModelAndView loginCustomerInformationForm(@ModelAttribute("customerkeycity") Customer customer,@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("city") String c)
	   {
		     
		  
		   
			  
		   
		   String user=customer.getUsername();
		   String pass=customer.getPassword();
		   System.out.println(user);
		   
		 
		   System.out.println(pass);
		   System.out.println(pid);
		   System.out.println(r);
		   
		   Customer actualcustomer=customerservice.findUsernameandPassword(user,pass);
		   
		   System.out.println(actualcustomer.getFirstname());
		   
		   String username1 =actualcustomer.getUsername();
		   String password1= actualcustomer.getPassword();
		    
			   Customer customerobj = customerservice.findCustomerByUsername(username1,password1);
		       System.out.println(customerobj.getLastname());
		       List<Zones> zlist = zoneservice.findByCityService(c);
			   List<ParkingLot> plist=parkinglotservice.saveCustomer(actualcustomer, r,pid);
			   ModelAndView mav = new ModelAndView("logincustomerinfobycity");
			   mav.addObject("parkinglistcity",plist);
			   mav.addObject("zoneitemlistcity",zlist);
			     
		   
			   return mav;
		  
	   }
	   @RequestMapping(value="/customerregistrationformbycity")
	   
	   public String customerRegistrationByCity()
	   {
		  
		 

		   return "customerregistrationbycity";
	   }
	 
	   @RequestMapping(value="/customerinformationformbycity",method=RequestMethod.POST)
	   public ModelAndView customerInformationByCity(@ModelAttribute("customerkeycity")@Valid Customer customer,BindingResult br)
	   {
		   
		   if (br.hasErrors()) 
		   {
			   ModelAndView mav = new ModelAndView("customerregistrationbycity");
			   return mav;
				
			}
		   
		   
		   System.out.println("hello customer information form");
		   customerservice.saveCustomer(customer);
		   ModelAndView mav = new ModelAndView("accountcreatedbycity");
		   mav.addObject("customerkey",customer);

		   return mav;
		   
		   
	   }
	   @GetMapping("/checkoutbycity")
	   public String checkOutByCity()
	   {
		   return "checkout";
	   }
	   
	   @GetMapping("/homebycity")
	   public String HomeByCity()
	   {
		   return "home";
	   }
	   @RequestMapping(value="/guestcheckoutformbycity",method=RequestMethod.GET)
		public ModelAndView guestCheckoutForm(@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("city") String c)
		{
		   
		   List<Zones> z = zoneservice.findByCityService(c);
		   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailabilityByCity(pid, c,false);
		   ModelAndView mav = new ModelAndView("guestcheckoutbycity");
		   mav.addObject("reservationid",r);
		   mav.addObject("parkinglistcity", p);
		   mav.addObject("zoneitemlistcity",z);
		   return mav;
		}
	   
	   
	   
	   @ModelAttribute("parkinglotrkeybycity")
	   public ParkingLot setupParkingLotkeyByCity() 
	   {
	   	return new ParkingLot();
	   }
	   
	   @RequestMapping(value="/recieptformbycity",method=RequestMethod.GET)
		public ModelAndView recieptFormByCity(@RequestParam("city") String c,@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@ModelAttribute("customerkeybycity") Customer customer)
		{
		   
		 
		   
		   
		   String user = customer.getUsername();
		   String pass = customer.getPassword();
		   System.out.println(user);
		   Customer actualcustomer = customerservice.findUsernameandPassword(user, pass);
		   List<Zones> zlist = zoneservice.findByCityService(c);
		   List<ParkingLot> plist=parkinglotservice.saveCustomer(actualcustomer, r,pid);
		   ModelAndView mav = new ModelAndView("paymentsbycity");
		   mav.addObject("parkinglistcity", plist);
		   mav.addObject("zoneitemlistcity", zlist);
		 
				  
		 return mav;
		}
	   
	   @RequestMapping(value="/recieptguestformbycity",method=RequestMethod.GET)
	  	public ModelAndView recieptGuestFormbyCity(@RequestParam("city") String c ,@RequestParam("parkinglotid") Integer pid,@ModelAttribute("customerkey") Customer customer)
	  	{
		   
		  
	  	   
	  	 //  String user = customer.getUsername();
	  	  // String pass = customer.getPassword();
	  	   //System.out.println(user);
	  	   Customer actualcustomer = customerservice.saveGuestCustomer(customer);
	  	   List<Zones> zlist = zoneservice.findByCityService(c);
	  	   List<ParkingLot> plist=parkinglotservice.saveGuestCustomer(actualcustomer,pid);
	  	   ModelAndView mav = new ModelAndView("recieptbycity");
	  	   mav.addObject("parkinglist", plist);
	  	   mav.addObject("zoneitemlist", zlist);
	  	 
	  			  
	  	 return mav;
	  	}
	   
	   
}
