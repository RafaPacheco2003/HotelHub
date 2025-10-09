package com.rooms.application.usecases;

import com.rooms.domian.exceptions.RoomNotFoundException;
import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.ExistsByIdUseCase;
import com.rooms.domian.ports.in.RetrieveUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUseCaseImpl implements RetrieveUseCase {
    private final RepositoryPort repositoryPort;


    public RetrieveUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Optional<Rooms> findById(Long roomId) {
        if (!repositoryPort.existsById(roomId)) {
            throw new RoomNotFoundException(roomId);
        }
        return repositoryPort.findById(roomId);
    }
    @Override
    public List<Rooms> findAll() {
        List<Rooms> rooms = repositoryPort.findAll();
        if (rooms.isEmpty()) {
            throw new RoomNotFoundException("No rooms found in database");
        }
        return rooms;
    }
}