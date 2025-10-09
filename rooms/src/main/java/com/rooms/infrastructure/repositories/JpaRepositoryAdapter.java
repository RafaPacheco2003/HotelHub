package com.rooms.infrastructure.repositories;

import com.rooms.domian.models.Rooms;
import com.rooms.domian.ports.out.RepositoryPort;
import com.rooms.infrastructure.entities.RoomsEntity;
import com.rooms.infrastructure.mappers.RoomMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaRepositoryAdapter implements RepositoryPort {
    private final RoomMapper roomMapper;
    private final JpaRepository jpaRepository;

    public JpaRepositoryAdapter(RoomMapper roomMapper, JpaRepository jpaRepository) {
        this.roomMapper = roomMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Rooms create(Rooms rooms) {
        return roomMapper.toModel(jpaRepository.save(roomMapper.toEntity(rooms)));
    }

    @Override
    public Optional<Rooms> findById(Long roomId) {
        return jpaRepository.findById(roomId)
                .map(roomMapper::toModel);
    }

    @Override
    public List<Rooms> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(roomMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Rooms update(Long roomId, Rooms rooms) {


        RoomsEntity entity = roomMapper.toEntity(rooms);
        entity.setRoomId(roomId);

        return roomMapper.toModel(jpaRepository.save(entity));
    }

    @Override
    public Boolean delete(Long roomId) {
        if (jpaRepository.existsById(roomId)) {
            jpaRepository.deleteById(roomId);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Long roomId) {
        return jpaRepository.existsById(roomId);
    }

    @Override
    public List<Rooms> findByRoomType(String roomType) {
        return jpaRepository.findByRoomType(roomType)
                .stream()
                .map(roomMapper::toModel)
                .collect(Collectors.toList());
    }

}
