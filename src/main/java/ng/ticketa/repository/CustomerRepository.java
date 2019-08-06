package ng.ticketa.repository;

import ng.ticketa.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	public Customer findByPhoneNumber(String phoneNumber);

}
