package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Desk;
import alessandro.angheben.GestionePrenotazioni.entities.Reservation;
import alessandro.angheben.GestionePrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Long> {


    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.desk =:desk AND r.reservationDate=:reservationDate")
    long findFreeDesksByReservationDate(Desk desk, LocalDate reservationDate);

    List<Reservation> findByUser(User user);


}
