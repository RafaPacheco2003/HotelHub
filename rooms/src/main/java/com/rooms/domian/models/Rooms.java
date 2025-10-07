package com.rooms.domian.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {


    private Long roomId;

    private String number;

    private String roomType;

    private String description;

    private Double pricePerNight;

}
