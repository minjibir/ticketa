package ng.ticketa.controllers;

import ng.ticketa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController
{
	@Autowired
	TripService tripsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}

	@GetMapping("/schedule")
	public String schedule(Model model)
	{
		model.addAttribute("trips", tripsService.getAllTrips());
		return "schedule";
	}

	@GetMapping("/about")
	public String about()
	{
		return "about";
	}

	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}

	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
//
//	@GetMapping("/register")
//	public String register()
//	{
//		return "register";
//	}

	@GetMapping("/logout")
	public String logout()
	{
		return "redirect:/login";
	}
}
