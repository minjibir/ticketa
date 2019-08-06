package ng.ticketa.repository;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
	public List<Ticket> findByCustomerId(Customer customer);
}
