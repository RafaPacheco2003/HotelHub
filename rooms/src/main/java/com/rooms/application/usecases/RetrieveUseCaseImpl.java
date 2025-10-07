package com.rooms.application.usecases;

import com.rooms.domian.models.Rooms;
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
        return  repositoryPort.findById(roomId);
    }

    @Override
    public List<Rooms> findAll() {
        return repositoryPort.findAll();
    }
}
