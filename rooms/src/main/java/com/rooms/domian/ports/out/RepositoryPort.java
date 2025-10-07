package com.rooms.domian.ports.out;

import com.rooms.domian.models.Rooms;

import java.util.List;
import java.util.Optional;

public interface RepositoryPort {
    Rooms create(Rooms rooms);
    Optional<Rooms> findById(Long roomId);
    List<Rooms> findAll();
    Rooms update(Long roomId, Rooms rooms);
    Boolean delete(Long roomId);
}
