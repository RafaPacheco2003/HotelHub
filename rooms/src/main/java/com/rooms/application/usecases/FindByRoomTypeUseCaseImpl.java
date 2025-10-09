package com.rooms.application.usecases;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.FindByRoomTypeUseCase;
import com.rooms.domian.ports.out.RepositoryPort;

import java.util.List;

public class FindByRoomTypeUseCaseImpl implements FindByRoomTypeUseCase {

    private final RepositoryPort repositoryPort;

    public FindByRoomTypeUseCaseImpl(RepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Rooms> findByRoomType(String roomType) {
        return repositoryPort.findByRoomType(roomType);
    }
}
