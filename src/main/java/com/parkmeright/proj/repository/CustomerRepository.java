package com.parkmeright.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parkmeright.proj.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

	 Customer findByUsernameAndPassword(@Param("username") String username,
             @Param("password") String password);

	  Customer findByEmail(String email);

}
