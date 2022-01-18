package ch.bbcag.f1api.repositories;

import ch.bbcag.f1api.models.GP;
import org.springframework.boot.convert.Delimiter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GPRepository extends CrudRepository<GP, Integer> {
    @Query("SELECT g FROM GP g JOIN g.drivers d WHERE d.lastname LIKE CONCAT('%',:name,'%')")
    Iterable<GP> findByWinnerLastName(@Param("name") String name);

    @Query("SELECT g FROM GP g JOIN g.drivers WHERE g.id = :id")
    Iterable<GP> findById(@Param("id") int id);

    @Query("SELECT g FROM GP g JOIN g.drivers WHERE g.year = :year")
    Iterable<GP> findByYear(@Param("year") int year);

    @Query("SELECT g FROM GP g JOIN g.drivers d WHERE d.lastname LIKE CONCAT('%', :name, '%') AND g.year = :year")
    Iterable<GP> findByYearAndLastName(@Param("name") String name, @Param("year") Integer year);
}
