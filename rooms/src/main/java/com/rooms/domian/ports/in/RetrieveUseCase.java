package com.rooms.domian.ports.in;

import com.rooms.domian.models.Rooms;

import java.util.List;
import java.util.Optional;

public interface RetrieveUseCase {

    Optional<Rooms> findById(Long roomId);
    List<Rooms> findAll();


}
