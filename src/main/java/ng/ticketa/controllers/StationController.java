package ng.ticketa.controllers;

import javax.validation.Valid;
import ng.ticketa.models.Station;
import ng.ticketa.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StationController
{
	@Autowired
	private StationService stationService;

	@GetMapping("/stations")
	public String stations(Model model)
	{
		model.addAttribute("stations", stationService.findAll());
		return "views/stations/list";
	}

	@GetMapping("/stations/add")
	public String addStation(Model model)
	{
		model.addAttribute(new Station());
		return "views/stations/add";
	}

	@PostMapping("/stations/add")
	public String addStation(Model model, @ModelAttribute @Valid Station station, BindingResult bindingResult)
	{
		if (!bindingResult.hasErrors()) {
			stationService.createStation(station);
			model.addAttribute("station", station);
			return "views/stations/view";
		}
		model.addAttribute("errors", bindingResult);
		return "views/stations/add";
	}
}
