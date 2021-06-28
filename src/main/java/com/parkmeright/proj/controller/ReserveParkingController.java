package com.parkmeright.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReserveParkingController 
{
	@GetMapping("/reserveparking")
	   public String parkNowHome()
	   {
		   return "reserveparking";
	   }

}
