package alessandro.angheben.GestionePrenotazioni.dao;

import alessandro.angheben.GestionePrenotazioni.entities.Desk;
import alessandro.angheben.GestionePrenotazioni.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private DeskDAO deskDAO;

    public void save(Reservation reservation) {

        //controllo che la postazione sia libera per quella data
        List<Desk> freeDesksList = deskDAO.findFreeDesksByReservationDate(reservation.getReservationDate());
        boolean freeDesk = freeDesksList.stream().anyMatch(desk -> desk.getId() == reservation.getDesk().getId());

        //controllo che l'utente non abbia gia una prenotazione in quella data
        List<Reservation> freeUsers = reservationDAO.findByUser(reservation.getUser());
        boolean alreadyReservedForThisUser = freeUsers.stream().anyMatch(res -> res.getReservationDate().equals(reservation.getReservationDate()));


        if (freeDesk) {
            if (!alreadyReservedForThisUser) {
                reservationDAO.save(reservation);
                System.out.println("Congratulazioni, RESERVATION salvata con successo !");
            } else {
                System.out.println("Ops, hai gia una RESERVATION per questa data!");
            }

        } else {
            System.out.println("Ops, la DESK è già occupata in questa data !");
        }
    }
}