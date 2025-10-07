package com.rooms.infrastructure.mappers;

import com.rooms.domian.models.Rooms;
import com.rooms.infrastructure.dto.request.RequestCreateRoom;
import com.rooms.infrastructure.dto.response.ResponseRoom;
import com.rooms.infrastructure.entities.RoomsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    // Entity to Model
    Rooms toModel(RoomsEntity entity);

    // Model to Entity
    RoomsEntity toEntity(Rooms model);

    // Entity to Response DTO
    ResponseRoom toResponse(RoomsEntity entity);

    // Request DTO to Entity
    @Mapping(target = "roomId", ignore = true)
    RoomsEntity toEntity(RequestCreateRoom request);

    // Request DTO to Model
    @Mapping(target = "roomId", ignore = true)
    Rooms toModelFromRequest(RequestCreateRoom request);

    // Model to Response DTO
    ResponseRoom toResponseFromModel(Rooms model);
}