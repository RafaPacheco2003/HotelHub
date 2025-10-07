package com.rooms.application.usecases;

import com.rooms.domian.ports.in.DeleteUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

public class DeleteUseCaseImpl implements DeleteUseCase {

    private final RepositoryPort repositoryPort;


    public DeleteUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }


    @Override
    public Boolean delete(Long roomId) {
        return repositoryPort.delete(roomId);
    }
}
