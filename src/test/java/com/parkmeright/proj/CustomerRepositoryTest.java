package com.parkmeright.proj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.parkmeright.proj.entity.Customer;
import com.parkmeright.proj.repository.CustomerRepository;


@DataJpaTest

public class CustomerRepositoryTest 
{

	
		@Autowired 
		private CustomerRepository cusrepo;
		
		
		@Test
		void testSave() {
			Customer cust = new Customer("Jack", "cat", "1 lovell dr","jack@gmail.com",123456L,"jackusername","passwordjack",123123);
			cusrepo.save(cust);
			System.out.println(cust.getFirstname());
			assertNotNull(cust.getFirstname());
		}
		
		@Test
		void testUpdate()
		{
			Customer cust = new Customer("Jack", "cat", "1 lovell dr","jack@gmail.com",123456L,"jackusername","passwordjack",123123);
			cusrepo.save(cust);
			String expected=cust.getFirstname();
			cust.setFirstname("Bob");
			cusrepo.save(cust);
			String actual = cust.getFirstname();
			assertNotEquals(actual,expected);
			
		}
		
		@Test
		void testFindByEmail()
		{
			Customer expected = new Customer("Jill", "Jones", "2 lovell dr","jill@gmail.com",123457L,"jillusername","passwordjill",1231238);
			cusrepo.save(expected);
			expected.setEmail("jill@gmail.com");
			
			Customer actual =cusrepo.findByEmail("jill@gmail.com");
			assertEquals(expected,actual);
			
		}
		@Test
		void testDeleteCustomer()
		{
			Customer cust = new Customer("Jill", "Jones", "2 lovell dr","jill@gmail.com",123457L,"jillusername","passwordjill",1231238);
			cusrepo.delete(cust);
			assertNull(cusrepo.findByEmail("jill@gmail.com"));
			
		}

		

}
