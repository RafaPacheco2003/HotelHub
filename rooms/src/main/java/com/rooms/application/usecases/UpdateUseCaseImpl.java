package com.rooms.application.usecases;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.UpdateUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

public class UpdateUseCaseImpl implements UpdateUseCase {
    private final RepositoryPort repositoryPort;

    public UpdateUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }


    @Override
    public Rooms update(Long roomId, Rooms rooms) {
        return repositoryPort.update(roomId, rooms);
    }
}
