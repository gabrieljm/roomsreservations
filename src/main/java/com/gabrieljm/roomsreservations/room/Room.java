package com.gabrieljm.roomsreservations.room;

import com.gabrieljm.roomsreservations.reservation.Reservation;
import jakarta.persistence.*;

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
}
