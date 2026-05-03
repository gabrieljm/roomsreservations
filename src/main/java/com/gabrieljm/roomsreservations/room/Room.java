package com.gabrieljm.roomsreservations.room;

import com.gabrieljm.roomsreservations.reservation.Reservation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reservation")
    private List<Reservation> reservations;

    @Column(unique = true, nullable = false)
    private String identifier;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Boolean active;

    public Boolean isActive() {
        return active;
    }

    public Boolean hasSufficientCapacity(Integer numberOfParticipants) {
        return numberOfParticipants <= this.capacity;
    }

//    public Reservation reserve(LocalDateTime startTime, LocalDateTime endTime, Integer numberOfParticipants) {
//        if (Boolean.FALSE.equals(this.active)) {
//            throw new IllegalStateException("Room is inactive");
//        }
//
//        if (numberOfParticipants > capacity) {
//            throw new IllegalArgumentException("Insufficient room capacity");
//        }
//
//        return new Reservation(this, startTime, endTime, numberOfParticipants);
//    }
}
