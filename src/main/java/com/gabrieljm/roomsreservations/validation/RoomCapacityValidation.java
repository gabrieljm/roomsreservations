package com.gabrieljm.roomsreservations.validation;

import com.gabrieljm.roomsreservations.reservation.ReservationSolicitationDto;
import com.gabrieljm.roomsreservations.room.Room;
import com.gabrieljm.roomsreservations.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCapacityValidation implements ReservationValidation {

    @Autowired
    private RoomRepository roomRepository;

    public void validate(ReservationSolicitationDto dto) {
        Room room = roomRepository.findByIdentifier(dto.roomIdentifier());

        if (!room.hasSufficientCapacity(dto.numberOfParticipants())) {
            throw new IllegalStateException("Insufficient room capacity");
        }
    }
}
