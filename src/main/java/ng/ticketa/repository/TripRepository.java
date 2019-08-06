package ng.ticketa.repository;

import ng.ticketa.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer>
{

}
