package com.parkinglot.spots;

import com.parkinglot.enums.ParkingSpotType;

public class Large extends ParkingSpot{

    public Large(String id) {
        super(id);
        this.spotType = ParkingSpotType.LARGE;
    }
}