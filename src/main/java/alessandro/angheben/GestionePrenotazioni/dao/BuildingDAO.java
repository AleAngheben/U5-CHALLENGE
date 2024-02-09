package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingDAO extends JpaRepository<Building, Long> {

    List<Building> findByName(String name);

    List<Building> findByCity(String city);

    List<Building> findByAddress(String address);

}
