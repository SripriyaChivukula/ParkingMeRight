package com.parkmeright.proj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parkmeright.proj.entity.Customer;
import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Zones;
import com.parkmeright.proj.services.CustomerService;
import com.parkmeright.proj.services.ParkingLotService;
import com.parkmeright.proj.services.PaymentsService;
import com.parkmeright.proj.services.ZonesService;
import com.parmeright.proj.customexception.NullCustomException;




@Controller
@ControllerAdvice
public class ParkNowController
{  
   @Autowired
   private ZonesService zoneservice;
   @Autowired
   private ParkingLotService parkinglotservice;
   @Autowired
   private CustomerService customerservice;
   @Autowired
   private PaymentsService paymentservice;
   
  public static boolean alreadyexecuted=false;
   
   
   @SuppressWarnings("finally")
   @GetMapping("/parknow")
   public String parkNowHome()
   { 
	 
   //  zoneservice.addParkingLots();
    
   return "parknow";
   }
  
   
   @RequestMapping(value="/parknowresults",method=RequestMethod.POST)
   public ModelAndView getParkingInfoByZones(@RequestParam("zonenumber") Integer i) 
   {
	   try 
	   {
	   System.out.println("I'm in the custom exception method");
	   System.out.println(i);
	  
	    if((i==0)||i>3||i==null)
	    {
	    	throw new NullCustomException("zonenumber can be only 1,2 or 3");
	    }
	    else 
	    {
	    	 
		  List<Zones> z = zoneservice.findByZonenumberService(i);
	  
	    List<ParkingLot> p  = parkinglotservice.getParkingLotsByZonenumber(i);
	    
	   
	    ModelAndView mav = new ModelAndView("parknowresults"); 
	    mav.addObject("parkinglist",p);
	    mav.addObject("zoneitemlist",z);
	    return mav;
	   
	    }
	   }
	    catch(NullCustomException e)
	    {
	    	ModelAndView mav = new ModelAndView("NullCustomException"); 
	    	return mav;
	    }
	 
   }
 /*  @RequestMapping(value="/parknowresultsupdate",method=RequestMethod.GET)
   public ModelAndView updateParkingAvailability(@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber")Integer i,Boolean availability)
   {
	   
	   boolean p1=parkinglotservice.FindParkingLotAvailabilityZoneNumber(pid,i);
	   
	   if( p1==true)
		  {
	    List<Zones> z = zoneservice.findByZonenumberService(i);
	    List<ParkingLot> p = parkinglotservice.updateParkingLotAvailability(pid, i,false);
	
	   ModelAndView mav = new ModelAndView("parknowresults"); 
	   mav.addObject("parkinglist",p);
	   mav.addObject("zoneitemlist",z);
	   mav.addObject(i);
	   mav.addObject(pid);
	   return mav;
       }
	   else
		  {
			  ModelAndView mav = new ModelAndView("availability"); 
			  return mav;
		  }
   
   }*/
   
   @RequestMapping(value="/parknowunreserve",method=RequestMethod.GET)
   public ModelAndView unreserveParkingAvailability(@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber")Integer i,Boolean availability)
   {
	   boolean p1=parkinglotservice.FindParkingLotAvailabilityZoneNumber(pid,i);
	   
		  if( p1==false)
		   {
	
	    List<Zones> z = zoneservice.findByZonenumberService(i);
	    List<ParkingLot> p = parkinglotservice.updateParkingLotAvailability(pid, i,true);
	 
	   ModelAndView mav = new ModelAndView("parknowresults"); 
	   mav.addObject("parkinglist",p);
	   mav.addObject("zoneitemlist",z);
	   return mav;
		}
		  else
		  {
			  ModelAndView mav = new ModelAndView("availability"); 
			  return mav;
		  }
	   
   }
   
   @RequestMapping(value="/parknowpayments",method=RequestMethod.GET)
   public ModelAndView Payments(@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber")Integer i,Boolean availability)
   {
       boolean p1=parkinglotservice.FindParkingLotAvailabilityZoneNumber(pid,i);
	   
	  if( p1==true)
	   {
	   List<Zones> z = zoneservice.findByZonenumberService(i);
	   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailability(pid, i,false);
	  
	    System.out.println(pid);
	
	    ModelAndView mav = new ModelAndView("checkout");
	    mav.addObject("parkinglist",p);
	    mav.addObject("zoneitemlist",z);
	 
	    mav.addObject(pid);
	    mav.addObject(i);
	 
	   
	   return mav;
	   }
	  else
	  {
		  ModelAndView mav = new ModelAndView("availability"); 
		  return mav;
	  }
   }
   
   
   
   @RequestMapping(value="/login",method=RequestMethod.GET)
   public ModelAndView loginForm(@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber")Integer i,Model model)
   {
	
	   
	   List<Zones> z = zoneservice.findByZonenumberService(i);
	   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailability(pid, i,false);
	   ModelAndView mav = new ModelAndView("login");
	
	    mav.addObject("parkinglist",p);
	    mav.addObject("zoneitemlist",z);
	    System.out.println(r);
	    Integer reservationid= r;
	    Integer parkinglotid=pid;
	    System.out.println(pid);
	  
	   mav.addObject("reservationid",reservationid);
	   mav.addObject("parkinglotid",parkinglotid);
	   model.addAttribute("reservationid",reservationid);
	   model.addAttribute("parkinglotid",parkinglotid);
	
	   return mav;
	  
	  
   }
   
   

   @ModelAttribute("customerkey")
   public Customer setupCustomer() 
   {
   	return new Customer();
   }
   
  
   @RequestMapping(value="/logincustomerinformation",method=RequestMethod.GET)
   public ModelAndView loginCustomerInformationForm(@ModelAttribute("customerkey") Customer customer,@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber") Integer i) throws Exception
   {
	   try {
	     
	  // System.out.println("hello reciept form");
	   //System.out.println("hello login");
		  
	   
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
	       List<Zones> zlist = zoneservice.findByZonenumberService(i);
		   List<ParkingLot> plist=parkinglotservice.saveCustomer(actualcustomer, r,pid);
		   ModelAndView mav = new ModelAndView("logincustomerinfo");
		   mav.addObject("parkinglist",plist);
		   mav.addObject("zoneitemlist",zlist);
		     
	   
		   return mav;
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return null;
		   
	   }
   }
  
   
   
   
   @RequestMapping(value="/customerregistrationform",method=RequestMethod.GET)
   public String customerRegistration()
   {
	  
	  
	   return "customerregistration";
   }
 
   @RequestMapping(value="/customerinformationform",method=RequestMethod.POST)
   public ModelAndView customerInformation(@ModelAttribute("customerkey") @Valid Customer customer,BindingResult br)
   {
	   if (br.hasErrors()) 
	   {
		   ModelAndView mav = new ModelAndView("customerregistration");
		   return mav;
			
		}
	   System.out.println("hello customer information form");
	   customerservice.saveCustomer(customer);
	   ModelAndView mav = new ModelAndView("customerinformation");
	   mav.addObject("customerkey",customer);

	   return mav;
	   
	   
   }
   
   @GetMapping("/checkout")
   public String checkOut()
   {
	   return "checkout";
   }
   
   @GetMapping("/home")
   public String Home()
   {
	   return "home";
   }
   
   
   @RequestMapping(value="/guestcheckoutform",method=RequestMethod.GET)
	public ModelAndView guestCheckoutForm(@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@RequestParam("zonenumber") Integer i)
	{
	 //  System.out.println(r);
	   List<Zones> z = zoneservice.findByZonenumberService(i);
	   List<ParkingLot> p = parkinglotservice.updateParkingLotAvailability(pid, i,false);
	   ModelAndView mav = new ModelAndView("guestcheckout");
	   mav.addObject("reservationid",r);
	   mav.addObject("parkinglist", p);
	   mav.addObject("zoneitemlist",z);
	   return mav;
	}
   
   @ModelAttribute("parkinglotrkey")
   public ParkingLot setupParkingLotkey() 
   {
   	return new ParkingLot();
   }
   
   @RequestMapping(value="/recieptform",method=RequestMethod.GET)
	public ModelAndView recieptForm(@RequestParam("zonenumber") Integer i,@RequestParam("reservationid") Integer r,@RequestParam("parkinglotid") Integer pid,@ModelAttribute("customerkey")  Customer customer)
	{
	   
	   
	   String user = customer.getUsername();
	   String pass = customer.getPassword();
	   System.out.println(user);
	   Customer actualcustomer = customerservice.findUsernameandPassword(user, pass);
	   List<Zones> zlist = zoneservice.findByZonenumberService(i);
	   List<ParkingLot> plist=parkinglotservice.saveCustomer(actualcustomer, r,pid);
	   ModelAndView mav = new ModelAndView("payments");
	   mav.addObject("parkinglist", plist);
	   mav.addObject("zoneitemlist", zlist);
	 
			  
	 return mav;
	}
   @RequestMapping(value="/recieptguestform",method=RequestMethod.GET)
  	public ModelAndView recieptFormGuest(@RequestParam("zonenumber") Integer i,@RequestParam("parkinglotid") Integer pid,@ModelAttribute("customerkey") @Valid Customer customer ,BindingResult br)
  	{
	   
	   if (br.hasErrors()) 
	   {
		   ModelAndView mav = new ModelAndView("guestcheckout");
		   return mav;
			
		}
  	   
  	   
  	 //  String user = customer.getUsername();
  	  // String pass = customer.getPassword();
  	   //System.out.println(user);
  	   Customer actualcustomer = customerservice.saveGuestCustomer(customer);
  	   List<Zones> zlist = zoneservice.findByZonenumberService(i);
  	   List<ParkingLot> plist=parkinglotservice.saveGuestCustomer(actualcustomer,pid);
  	   ModelAndView mav = new ModelAndView("reciept");
  	   mav.addObject("parkinglist", plist);
  	   mav.addObject("zoneitemlist", zlist);
  	 
  			  
  	 return mav;
  	}
   @GetMapping("/delete")
   public String deleteCustomer(@ModelAttribute("customerkey") Customer customer)
   {
	   customerservice.deleteCustomer(customer);
	   return "home";
   }
   
}
