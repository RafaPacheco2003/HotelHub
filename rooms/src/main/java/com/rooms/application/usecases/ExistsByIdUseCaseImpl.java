package com.rooms.application.usecases;

import com.rooms.domian.exceptions.RoomNotFoundException;
import com.rooms.domian.ports.in.ExistsByIdUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

public class ExistsByIdUseCaseImpl implements ExistsByIdUseCase {

    private final RepositoryPort repositoryPort;

    public ExistsByIdUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void existsById(Long roomId) {
        if (!repositoryPort.existsById(roomId)) {
            throw new RoomNotFoundException(roomId);
        }
    }
}