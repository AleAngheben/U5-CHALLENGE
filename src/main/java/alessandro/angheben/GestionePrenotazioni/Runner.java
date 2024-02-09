package alessandro.angheben.GestionePrenotazioni;

import alessandro.angheben.GestionePrenotazioni.dao.BuildingService;
import alessandro.angheben.GestionePrenotazioni.dao.DeskService;
import alessandro.angheben.GestionePrenotazioni.dao.ReservationService;
import alessandro.angheben.GestionePrenotazioni.dao.UserService;
import alessandro.angheben.GestionePrenotazioni.entities.Building;
import alessandro.angheben.GestionePrenotazioni.entities.Desk;
import alessandro.angheben.GestionePrenotazioni.entities.Reservation;
import alessandro.angheben.GestionePrenotazioni.entities.User;
import alessandro.angheben.GestionePrenotazioni.enums.TypeDesk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private DeskService deskService;

    @Autowired
    private ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {

        //CREO 2 BUILDING

        Building buildingRome = new Building("Super palazzo", "via palazzoni", "Roma");
        Building buildingMilan = new Building("Piccolo palazzo", "via palazzini piccoli", "Milano");
        buildingService.save(buildingRome);
        buildingService.save(buildingMilan);

        //CREO 3 POSTAZIONI PER OGNI BUILDING

        //PRIVATE
        Desk deskRomeOne = new Desk("piccola stanza roma", TypeDesk.PRIVATE, 1, buildingRome);
        Desk deskMilanOne = new Desk("piccola stanza milano", TypeDesk.PRIVATE, 1, buildingMilan);
        deskService.save(deskRomeOne);
        deskService.save(deskMilanOne);


        //MEETING
        Desk deskRomeTwo = new Desk("meeting room roma", TypeDesk.MEETING_ROOM, 5, buildingRome);
        Desk deskMilanTwo = new Desk("meeting room milano", TypeDesk.MEETING_ROOM, 5, buildingMilan);
        deskService.save(deskRomeTwo);
        deskService.save(deskMilanTwo);


        //OPENSPACE
        Desk deskRomeThree = new Desk("openspace roma", TypeDesk.OPENSPACE, 10, buildingRome);
        Desk deskMilanThree = new Desk("openspace roma", TypeDesk.OPENSPACE, 10, buildingMilan);
        deskService.save(deskRomeThree);
        deskService.save(deskMilanThree);

        //CREO 3 USER

        User userOne = new User("princo", "Marco","Materazzi","Materazzi@gmail.com");
        User userTwo = new User("Capitano", "Francesco", "Totti","ercapitano@gmail.com");
        User userThree = new User("Talismano","Simone","Padoin","simo68@gmail.com");
        userService.save(userOne);
        userService.save(userTwo);
        userService.save(userThree);


        //CREO 1 PRENOTAZOINE PER OGNI UTENTE

        Reservation reservationOne = new Reservation(userOne,deskMilanOne, LocalDate.now());
        Reservation reservationTwo = new Reservation(userTwo,deskRomeOne, LocalDate.now());
        Reservation reservationThree = new Reservation(userThree,deskMilanTwo, LocalDate.now());
        reservationService.save(reservationOne);
        reservationService.save(reservationTwo);
        reservationService.save(reservationThree);

        System.out.println("Helloooooooooooooooooooooooooo");
    }


}
