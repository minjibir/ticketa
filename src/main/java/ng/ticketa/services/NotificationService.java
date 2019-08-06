package ng.ticketa.services;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Notification;
import ng.ticketa.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService
{
	@Autowired
	NotificationRepository notificationRepository;

	public List<Notification> findByCustomerId(Customer customer)
	{
		return notificationRepository.findByCustomerId(customer);
	}

	public List<Notification> getAllNotifications()
	{
		return notificationRepository.findAll();
	}
}
