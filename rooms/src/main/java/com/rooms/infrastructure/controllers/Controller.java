package com.rooms.infrastructure.controllers;

import com.rooms.application.services.Services;
import com.rooms.domian.models.Rooms;
import com.rooms.infrastructure.dto.request.RequestCreateRoom;
import com.rooms.infrastructure.dto.response.ResponseRoom;
import com.rooms.infrastructure.mappers.RoomMapper;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
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
    public ResponseEntity<?> findById(@PathVariable Long roomId) {
        Optional<Rooms> room = services.findById(roomId);
        return ResponseEntity.ok(room.map(roomMapper::toResponseFromModel));
    }


    @GetMapping
    public ResponseEntity<List<ResponseRoom>> findAll() {
        List<ResponseRoom> response = services.findAll().stream()
                .map(roomMapper::toResponseFromModel)
                .toList();
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{roomId}")
    public ResponseEntity<?> update(@PathVariable Long roomId, @RequestBody RequestCreateRoom request) {
        Rooms room = roomMapper.toModelFromRequest(request);
        Rooms updatedRoom = services.update(roomId, room);
        return ResponseEntity.ok(roomMapper.toResponseFromModel(updatedRoom));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long roomId) {
        services.delete(roomId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{roomType}")
    public ResponseEntity<List<ResponseRoom>> findByRoomType(@PathVariable String roomType) {
      List<ResponseRoom> response = services.findByRoomType(roomType)
              .stream()
              .map(roomMapper::toResponseFromModel)
              .toList();

      return ResponseEntity.ok(response);

    }
}
