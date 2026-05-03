package com.gabrieljm.roomsreservations.validation;

import com.gabrieljm.roomsreservations.reservation.ReservationSolicitationDto;

public interface ReservationValidation {

    void validate(ReservationSolicitationDto dto);
}
