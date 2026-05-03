package com.gabrieljm.roomsreservations.reservation;

import com.gabrieljm.roomsreservations.room.Room;
import com.gabrieljm.roomsreservations.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    public Reservation(){}

    public Reservation(Room room, LocalDateTime startTime, LocalDateTime endTime, Integer numberOfParticipants) {
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfParticipants = numberOfParticipants;
        this.reservationTime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    @Min(1)
    private Integer numberOfParticipants;

    @Column(nullable = false)
    private LocalDateTime reservationTime;
}
