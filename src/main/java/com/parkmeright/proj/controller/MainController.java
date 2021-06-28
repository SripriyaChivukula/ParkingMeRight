package com.parkmeright.proj.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.parkmeright.proj.entity.ParkingLot;
import com.parkmeright.proj.entity.Payments;
import com.parkmeright.proj.entity.Timeslot;
import com.parkmeright.proj.entity.Zones;
import com.parkmeright.proj.services.ZonesService;

@Controller
public class MainController 
{
	
   @GetMapping("/parkmeright")
	public String homePage()
	{
	  
	   
	 
		return "home";
	}
   @GetMapping("/contactus")
   
   public String Contact()
   {
	   return "contactus";
   }
   
}
