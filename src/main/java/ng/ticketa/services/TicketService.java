package ng.ticketa.services;

import java.util.List;
import ng.ticketa.models.Customer;
import ng.ticketa.models.Ticket;
import ng.ticketa.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService
{
	@Autowired
	private TicketRepository ticketRepository;
	public Object findByCustomerId;

	public void createTicket(Ticket ticket)
	{
		ticketRepository.save(ticket);
	}

	public List<Ticket> findAll()
	{
		return ticketRepository.findAll();
	}

	public Ticket getTicket(int ticketId)
	{
		return ticketRepository.getOne(ticketId);
	}

	public List<Ticket> findByCustomerId(Customer customer)
	{
		return ticketRepository.findByCustomerId(customer);
	}
}
