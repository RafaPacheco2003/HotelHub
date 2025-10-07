package com.rooms.domian.ports.in;

import com.rooms.domian.models.Rooms;

public interface DeleteUseCase {

    Boolean delete(Long roomId);
}
