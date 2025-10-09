package com.rooms.domian.exceptions;

public class RoomNotFoundException extends DomainException {
    public RoomNotFoundException(Long roomId) {
        super("Room not found with id: " + roomId, "ROOM_NOT_FOUND");
    }

    public RoomNotFoundException(String message) {
        super(message, "ROOM_NOT_FOUND");
    }
}