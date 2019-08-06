package ng.ticketa.services;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Payment;
import ng.ticketa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> findByCustomerId(Customer customer)
	{
		return paymentRepository.findByCustomerId(customer);
	}

	public List<Payment> getAllPayments()
	{
		return paymentRepository.findAll();
	}
}
