package ng.ticketa.controllers;

import java.util.Calendar;
import javax.validation.Valid;
import ng.ticketa.models.Ticket;
import ng.ticketa.models.Trip;
import ng.ticketa.services.CustomerService;
import ng.ticketa.services.TicketService;
import ng.ticketa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController
{
	@Autowired
	private TicketService ticketService;

	@Autowired
	private TripService tripService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/tickets")
	public String tickets(Model model)
	{
		model.addAttribute("tickets", ticketService.findAll());
		return "views/tickets/list";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicket(Model model, @PathVariable(value = "id") int ticketId)
	{
		model.addAttribute("ticket", ticketService.getTicket(ticketId));
		return "tickets/view";
	}

	@PostMapping("/tickets/add")
	public String addTicket(Model model, @ModelAttribute @Valid Ticket ticket, BindingResult bindingResult)
	{
		if (!bindingResult.hasErrors()) {
			ticketService.createTicket(ticket);
			model.addAttribute("ticket", ticket);
			return "tickets/view/" + ticket.getTicketId();
		}
		model.addAttribute("errors", bindingResult);
		return "tickets/add";
	}

	@GetMapping("/book/{id}")
	public String bookTicket(Model model, @PathVariable(value = "id") int tripId)
	{
		Ticket ticket = new Ticket();
		Trip trip = tripService.getTrip(tripId);

		ticket.setCustomerId(customerService.getCustomer("08065000000"));
		ticket.setTripId(tripService.getTrip(tripId));
		ticket.setOnewayTicket(false);
		ticket.setDateBooked(Calendar.getInstance().getTime());

		ticketService.createTicket(ticket);
		return "redirect:https://paystack.com/pay/5v6hkzwxj1";
	}
}
