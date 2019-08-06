package ng.ticketa.repository;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer>
{
	public List<Notification> findByCustomerId(Customer customer);
}
