package com.rooms.domian.ports.in;

import com.rooms.domian.models.Rooms;
import com.rooms.infrastructure.entities.RoomType;
import java.util.List;

public interface FindByRoomTypeUseCase {
    List<Rooms> findByRoomType(String roomType);
}
