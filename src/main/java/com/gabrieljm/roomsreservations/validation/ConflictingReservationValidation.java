package com.gabrieljm.roomsreservations.validation;

import com.gabrieljm.roomsreservations.reservation.ReservationRepository;
import com.gabrieljm.roomsreservations.reservation.ReservationSolicitationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConflictingReservationValidation implements ReservationValidation {

    @Autowired
    private ReservationRepository reservationRepository;

    public void validate(ReservationSolicitationDto dto) {
        boolean hasConflictingReservation = reservationRepository.existsByRoomIdAndStartTimeBeforeAndEndTimeAfter(
                dto.roomIdentifier(), dto.endTime(), dto.startTime());

        if (hasConflictingReservation) {
            throw new IllegalStateException("Conflicting time with another reservation");
        }
    }
}
