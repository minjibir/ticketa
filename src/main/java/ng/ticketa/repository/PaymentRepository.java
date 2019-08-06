package ng.ticketa.repository;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
	public List<Payment> findByCustomerId(Customer customer);
}
