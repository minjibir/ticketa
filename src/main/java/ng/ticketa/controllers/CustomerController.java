package ng.ticketa.controllers;

import java.security.Principal;
import javax.validation.Valid;
import ng.ticketa.models.Customer;
import ng.ticketa.services.CustomerService;
import ng.ticketa.services.NotificationService;
import ng.ticketa.services.PaymentService;
import ng.ticketa.services.TicketService;
import ng.ticketa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionPhoneNumber")
public class CustomerController
{
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TripService tripService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/register")
	public String addCustomer(Model model)
	{
		model.addAttribute(new Customer());
		return "register";
	}

	@PostMapping("/register")
	public String addCustomer(Model model, @Valid Customer customer, Errors errors, @RequestParam String repassword)
	{
		if (!errors.hasErrors()) {
			if (customer.getPassword().equals(repassword)) {
				if (customerService.getCustomer(customer.getPhoneNumber()) == null) {
					bCryptPasswordEncoder = new BCryptPasswordEncoder();
					customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
					customerService.createCustomer(customer);
					return "success";
				} else {
					model.addAttribute("errors", "User with the same phone number exist");
					return "register";
				}
			} else {
				model.addAttribute("errors", "The two passwords did not match");
				return "register";
			}
		} else {
			model.addAttribute("errors", errors);
			return "register";
		}
	}

	@PostMapping("/login")
	public String loginCustomer(Model model, @RequestParam String phone_number, @RequestParam String password)
	{
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Customer customer = customerService.getCustomer(phone_number);

		if (customer != null && bCryptPasswordEncoder.matches(password, customer.getPassword())) {
			model.addAttribute("sessionPhoneNumber", customer.getPhoneNumber());
			model.addAttribute("tickets", ticketService.findByCustomerId(customer));
			model.addAttribute("payments", paymentService.findByCustomerId(customer));
			model.addAttribute("notifications", notificationService.findByCustomerId(customer));
			return "redirect:/dashboard";
		}

		model.addAttribute("errors", "Username or password incorrect");
		return "login";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal)
	{
		String pNumber = principal.getName();
		Customer customer = customerService.getCustomer(pNumber);
		model.addAttribute("tickets", ticketService.findByCustomerId(customer));
		model.addAttribute("payments", paymentService.findByCustomerId(customer));
		model.addAttribute("notifications", notificationService.findByCustomerId(customer));
		return "customer/dashboard";
	}
}
