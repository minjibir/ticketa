package ng.ticketa.controllers;

import javax.validation.Valid;
import ng.ticketa.models.Trip;
import ng.ticketa.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripController
{
	@Autowired
	TripService tripService;

	@GetMapping("/trips")
	public String trips(Model model)
	{
		model.addAttribute("attribute", "value");
		return "views/trips/list";
	}

	@GetMapping("/trips/add")
	public String addTrip(Model model)
	{
		model.addAttribute(new Trip());
		return "views/trips/add";
	}

	@PostMapping("/trips/add")
	public String addTrip(Model model, @ModelAttribute @Valid Trip trip, BindingResult bindingResult)
	{
		if (!bindingResult.hasErrors()) {
			tripService.createTrip(trip);
			model.addAttribute("trip", trip);
			return "views/trips/view";
		}
		model.addAttribute("errors", bindingResult);
		return "views/trips/add";
	}
}
