package ng.ticketa.services;

import ng.ticketa.models.Customer;
import ng.ticketa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerRepository;

	public void createCustomer(Customer customer)
	{
		customerRepository.save(customer);
	}

	public Customer getCustomer(String phoneNumber)
	{
		return customerRepository.findByPhoneNumber(phoneNumber);
	}
}
