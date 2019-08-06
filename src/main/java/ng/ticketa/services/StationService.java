package ng.ticketa.services;

import java.util.List;
import ng.ticketa.models.Station;
import ng.ticketa.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService
{
	@Autowired
	private StationRepository stationRepository;

	public void createStation(Station station)
	{
		stationRepository.save(station);
	}

	public List<Station> findAll()
	{
		return stationRepository.findAll();
	}
}
