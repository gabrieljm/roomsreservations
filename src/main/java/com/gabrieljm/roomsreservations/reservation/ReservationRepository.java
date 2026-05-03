package com.gabrieljm.roomsreservations.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
            SELECT 1
              FROM Reservation r
             WHERE r.room.identifier = :roomIdentifier
               AND r.startTime < :newEndTime
               AND r.endTime > :newStartTime
            """)
    boolean existsConflictingReservation(String roomIdentifier,
                                         LocalDateTime newEndTime,
                                         LocalDateTime newStartTime);
}
