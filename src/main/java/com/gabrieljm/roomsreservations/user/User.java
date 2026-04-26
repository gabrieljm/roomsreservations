package com.gabrieljm.roomsreservations.user;

import com.gabrieljm.roomsreservations.reservation.Reservation;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reservation")
    private List<Reservation> reservations;

    @Column(nullable = false)
    private String name;
}
