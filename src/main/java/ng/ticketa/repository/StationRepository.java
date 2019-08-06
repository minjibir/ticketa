package ng.ticketa.repository;

import ng.ticketa.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer>
{

}
