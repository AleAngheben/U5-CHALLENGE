package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Desk;
import alessandro.angheben.GestionePrenotazioni.enums.TypeDesk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeskService {

    @Autowired
    private DeskDAO deskDAO;

    public void save(Desk desk){
        deskDAO.save(desk);
        System.out.println("Congratulazioni, DESK salvato con successo !");
    }

    public List<Desk> findFreeDesksByReservationDate(LocalDate reservationDate){
        return deskDAO.findFreeDesksByReservationDate(reservationDate);
    }

    public List<Desk> findByTypeDesk(TypeDesk typeDesk){
        return deskDAO.findByTypeDesk(typeDesk);
    }
}
