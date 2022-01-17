package ch.bbcag.f1api.repositories;

import ch.bbcag.f1api.models.Drivers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DriversRepository extends CrudRepository<Drivers, Integer> {

    @Query("SELECT d FROM Drivers d WHERE d.id = :id")
    Iterable<Drivers> findByDriverId(@Param("id") int id);

}
