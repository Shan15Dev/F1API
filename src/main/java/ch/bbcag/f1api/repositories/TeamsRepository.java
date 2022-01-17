package ch.bbcag.f1api.repositories;

import ch.bbcag.f1api.models.Teams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeamsRepository extends CrudRepository<Teams, Integer> {

    @Query("SELECT t FROM Teams t WHERE t.name LIKE CONCAT('%', :name, '%')")
    Iterable<Teams> findByName(@Param("name") String name);

}
