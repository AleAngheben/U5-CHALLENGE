package alessandro.angheben.GestionePrenotazioni.entities;

import alessandro.angheben.GestionePrenotazioni.enums.TypeDesk;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "desks")
public class Desk {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_desk")
    private TypeDesk typeDesk;

    @Column(name = "max_guest")
    private int maxGuests;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "desk")
    @ToString.Exclude
    private List<Reservation> reservations;

    public Desk(String description, TypeDesk typeDesk, int maxGuests, Building building) {
        this.description = description;
        this.typeDesk = typeDesk;
        this.maxGuests = maxGuests;
        this.building = building;
    }
}
