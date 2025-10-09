package com.rooms.domian.exceptions;
public class InvalidRoomDataException extends DomainException {
    public InvalidRoomDataException(String message) {
        super(message, "INVALID_ROOM_DATA");
    }
}