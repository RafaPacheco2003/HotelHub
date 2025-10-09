package com.rooms.infrastructure.repositories;

import com.rooms.infrastructure.entities.RoomsEntity;

import java.util.List;

public interface JpaRepository extends org.springframework.data.jpa.repository.JpaRepository<RoomsEntity, Long> {

    List<RoomsEntity> findByRoomType(String roomType);
}
