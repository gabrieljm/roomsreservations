package com.gabrieljm.roomsreservations.validation;

import com.gabrieljm.roomsreservations.reservation.ReservationSolicitationDto;
import org.springframework.stereotype.Component;

@Component
public class StartTimeBeforeEndTimeValidation implements ReservationValidation {

    public void validate(ReservationSolicitationDto dto) {
        if (dto.endTime().isBefore(dto.startTime())) {
            throw new IllegalArgumentException("End time before start time");
        }
    }
}
