package com.rooms.application.services;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.*;

import java.util.List;
import java.util.Optional;

public class Services implements CreateUseCase, RetrieveUseCase, UpdateUseCase, DeleteUseCase, ExistsByIdUseCase, FindByRoomTypeUseCase {

    private  final CreateUseCase createUseCase;
    private final RetrieveUseCase retrieveUseCase;
    private final UpdateUseCase updateUseCase;
    private final DeleteUseCase deleteUseCase;
    private final ExistsByIdUseCase existsByIdUseCase;
    private final FindByRoomTypeUseCase findByRoomTypeUseCase;

    public Services(CreateUseCase createUseCase, RetrieveUseCase retrieveUseCase, UpdateUseCase updateUseCase, DeleteUseCase deleteUseCase, ExistsByIdUseCase existsByIdUseCase, FindByRoomTypeUseCase findByRoomTypeUseCase) {
        this.createUseCase = createUseCase;
        this.retrieveUseCase = retrieveUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.existsByIdUseCase = existsByIdUseCase;
        this.findByRoomTypeUseCase = findByRoomTypeUseCase;
    }


    @Override
    public Rooms create(Rooms rooms) {
        return createUseCase.create(rooms);
    }

    @Override
    public Boolean delete(Long roomId) {
        return deleteUseCase.delete(roomId);
    }

    @Override
    public Optional<Rooms> findById(Long roomId) {
        return retrieveUseCase.findById(roomId);
    }

    @Override
    public List<Rooms> findAll() {
        return retrieveUseCase.findAll();
    }

    @Override
    public Rooms update(Long roomId, Rooms rooms) {
        return updateUseCase.update(roomId, rooms);
    }

    @Override
    public void existsById(Long roomId) {
         existsByIdUseCase.existsById(roomId);
    }


    @Override
    public List<Rooms> findByRoomType(String roomType) {
        return findByRoomTypeUseCase.findByRoomType(roomType);
    }

}
