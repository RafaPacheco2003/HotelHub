package com.rooms.infrastructure.dto.request;

import com.rooms.infrastructure.entities.RoomType;

public record RequestCreateRoom(
        String number,
        RoomType roomType,
        String description,
        Double pricePerNight
) {
}
