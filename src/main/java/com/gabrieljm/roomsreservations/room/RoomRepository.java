package com.gabrieljm.roomsreservations.room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByIdentifier(String identifier);
}
