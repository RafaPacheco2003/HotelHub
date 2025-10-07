package com.rooms.infrastructure.dto.response;

import com.rooms.infrastructure.entities.RoomType;

public record ResponseRoom(
        Long roomId,
        String number,
        RoomType roomType,
        String description,
        Double pricePerNight
) {
}
