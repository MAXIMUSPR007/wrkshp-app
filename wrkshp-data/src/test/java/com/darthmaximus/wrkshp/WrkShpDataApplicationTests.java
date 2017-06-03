package com.darthmaximus.wrkshp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.darthmaximus.wrkshp.data.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WrkShpDataApplicationTests {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testCustomerRepository() {
//		customerRepository.find
	}

}
