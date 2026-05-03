package com.gabrieljm.roomsreservations.reservation;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservationSolicitationDto(
        @NotNull
        String roomIdentifier,

        @NotNull
        LocalDateTime startTime,

        @NotNull
        LocalDateTime endTime,

        @NotNull
        Integer numberOfParticipants) {
}
