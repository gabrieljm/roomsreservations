package com.gabrieljm.roomsreservations.reservation;

import com.gabrieljm.roomsreservations.validation.ReservationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private List<ReservationValidation> validations;

    public void createReservation(ReservationSolicitationDto dto) {
        validations.forEach(v -> v.validate(dto));
    }
}
