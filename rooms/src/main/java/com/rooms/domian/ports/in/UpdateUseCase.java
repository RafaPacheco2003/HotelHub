package com.rooms.domian.ports.in;

import com.rooms.domian.models.Rooms;

public interface UpdateUseCase {

    Rooms update(Long roomId, Rooms rooms);
}
