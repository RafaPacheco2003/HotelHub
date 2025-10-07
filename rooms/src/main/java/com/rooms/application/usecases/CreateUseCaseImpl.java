package com.rooms.application.usecases;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.CreateUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

public class CreateUseCaseImpl implements CreateUseCase {

    private final RepositoryPort repositoryPort;

    public CreateUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Rooms create(Rooms rooms) {
        return repositoryPort.create(rooms);
    }
}
