package com.rooms.infrastructure.repositories;

import com.rooms.infrastructure.entities.RoomsEntity;

public interface JpaRepository extends org.springframework.data.jpa.repository.JpaRepository<RoomsEntity, Long> {
}
