package com.parkmeright.proj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkmeright.proj.repository.ParkingLotRepository;
import com.parkmeright.proj.repository.PaymentsRepository;
import com.parkmeright.proj.repository.TimeSlotRepository;
import com.parkmeright.proj.repository.ZonesRepository;

@Service
public class PaymentsService 
{
	 private ZonesRepository repo;
	 private ParkingLotRepository prepo;
	 private TimeSlotRepository trepo;
	 private PaymentsRepository pyrepo;
	 @Autowired
	 public PaymentsService(ZonesRepository repo, ParkingLotRepository prepo,TimeSlotRepository trepo,PaymentsRepository pyrepo)
	 {
		 this.repo = repo;
	    	this.prepo = prepo;
	    	this.trepo = trepo;
	    	this.pyrepo=pyrepo;
	 }
}
