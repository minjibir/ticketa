package ng.ticketa.services;

import java.util.List;
import ng.ticketa.models.Trip;
import ng.ticketa.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService
{
	@Autowired
	private TripRepository tripRepository;

	public void createTrip(Trip trip)
	{
		tripRepository.save(trip);
	}

	public List<Trip> getAllTrips()
	{
		return tripRepository.findAll();
	}

	public Trip getTrip(int tripId)
	{
		return tripRepository.getOne(tripId);
	}
}
