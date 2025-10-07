package com.rooms.infrastructure.controllers;

import com.rooms.application.services.Services;
import com.rooms.domian.models.Rooms;
import com.rooms.infrastructure.dto.request.RequestCreateRoom;
import com.rooms.infrastructure.mappers.RoomMapper;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class Controller {
    private final Services services;

    private final RoomMapper roomMapper;

    public Controller(Services services, RoomMapper roomMapper) {
        this.services = services;
        this.roomMapper = roomMapper;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RequestCreateRoom request) {
        Rooms room = roomMapper.toModelFromRequest(request);
        Rooms roomCreate = services.create(room);
        return ResponseEntity.ok(roomMapper.toResponseFromModel(roomCreate));
    }


    @GetMapping("/{roomId}")
    public ResponseEntity<?> findById(@RequestBody Long roomId) {
        Optional<Rooms> room = services.findById(roomId);
        return ResponseEntity.ok(room.map(roomMapper::toResponseFromModel));
    }


    @GetMapping
    public ResponseEntity<List<Rooms>> findAll() {
        List<Rooms> rooms = services.findAll();
        return ResponseEntity.ok(rooms);
    }
}
