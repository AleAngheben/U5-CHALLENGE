package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Desk;
import alessandro.angheben.GestionePrenotazioni.enums.TypeDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeskDAO extends JpaRepository<Desk,Long> {

    @Query("SELECT d FROM Desk d WHERE d NOT IN (SELECT r.desk FROM Reservation r WHERE r.reservationDate = :reservationDate)")
    List<Desk> findFreeDesksByReservationDate( LocalDate reservationDate);
    List<Desk> findByTypeDesk(TypeDesk typeDesk);



}
