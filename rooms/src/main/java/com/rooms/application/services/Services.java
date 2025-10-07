package com.rooms.application.services;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.in.CreateUseCase;
import com.rooms.domian.ports.in.DeleteUseCase;
import com.rooms.domian.ports.in.RetrieveUseCase;
import com.rooms.domian.ports.in.UpdateUseCase;

import java.util.List;
import java.util.Optional;

public class Services implements CreateUseCase, RetrieveUseCase, UpdateUseCase, DeleteUseCase {

    private  final CreateUseCase createUseCase;
    private final RetrieveUseCase retrieveUseCase;
    private final UpdateUseCase updateUseCase;
    private final DeleteUseCase deleteUseCase;

    public Services(CreateUseCase createUseCase, RetrieveUseCase retrieveUseCase, UpdateUseCase updateUseCase, DeleteUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.retrieveUseCase = retrieveUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
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
}
