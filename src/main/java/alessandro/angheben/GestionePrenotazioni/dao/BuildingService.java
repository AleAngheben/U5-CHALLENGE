package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
@Autowired
    private BuildingDAO buildingDAO;

public void save(Building building){
    buildingDAO.save(building);
    System.out.println("Congratulazioni, BUILDING salvato con successo !");
}

public List<Building> findAll(){
    return buildingDAO.findAll();
}

public List<Building> findByName(String name){
    return buildingDAO.findByName(name);
}

public List<Building> findByCity(String city){
    return buildingDAO.findByCity(city);
}

public List<Building> findByAddress(String address){
    return buildingDAO.findByAddress(address);
}
}
