package com.rooms.domian.exceptions;

public class RoomAlreadyExistsException extends DomainException {

    public RoomAlreadyExistsException(String roomNumber) {
        super("Room already exists with number: " + roomNumber, "ROOM_ALREADY_EXISTS");
    }
}
