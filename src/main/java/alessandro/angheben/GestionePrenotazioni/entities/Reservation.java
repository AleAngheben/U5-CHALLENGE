package alessandro.angheben.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "reservations")
public class Reservation {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    public Reservation(User user, Desk desk, LocalDate reservationDate) {
        this.user = user;
        this.desk = desk;
        this.reservationDate = reservationDate;
    }
}
