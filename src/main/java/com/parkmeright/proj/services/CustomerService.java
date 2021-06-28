package com.parkmeright.proj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkmeright.proj.entity.Customer;
import com.parkmeright.proj.repository.CustomerRepository;
import com.parkmeright.proj.repository.ParkingLotRepository;
import com.parkmeright.proj.repository.PaymentsRepository;
import com.parkmeright.proj.repository.TimeSlotRepository;
import com.parkmeright.proj.repository.ZonesRepository;
@Service
public class CustomerService 
{
private ZonesRepository repo;
private ParkingLotRepository prepo;
private TimeSlotRepository trepo;
private PaymentsRepository pyrepo;
private CustomerRepository cusrepo;
@Autowired
public CustomerService(ZonesRepository repo,ParkingLotRepository prepo,TimeSlotRepository trepo,PaymentsRepository pyrepo,CustomerRepository cusrepo)
{
	this.repo=repo;
	this.prepo=prepo;
	this.trepo=trepo;
	this.pyrepo=pyrepo;
	this.cusrepo=cusrepo;
	
}
@Transactional
public void saveCustomer(Customer customer)
{
	cusrepo.save(customer);
}
public Customer findUsernameandPassword(String username1, String password1) 
{
	
	
	
	Customer customer=new Customer();
	
	customer=cusrepo.findByUsernameAndPassword(username1,password1);
    
	return customer;
	
}
public Customer findCustomerByUsername(String username1,String password1) 
{
	Customer customer=cusrepo.findByUsernameAndPassword(username1, password1);
	return customer;
}
public Customer findByUsername(String user,Integer pid) {
	
	
	
	return null;
}
@Transactional
public void deleteCustomer(Customer customer) 
{
	System.out.println("hello i'm is delete cusrepo");
	
	
	System.out.println(customer.getEmail());
	
	Customer deletecustomer=cusrepo.findByEmail(customer.getEmail());
	
	cusrepo.delete(deletecustomer);
}
@Transactional
public Customer saveGuestCustomer(Customer customer)
{
	customer.setUsername("guestusername");
	customer.setPassword("guestpassword");
	customer.setRewardpoints(0);
	cusrepo.save(customer);
	return customer;
}

}
