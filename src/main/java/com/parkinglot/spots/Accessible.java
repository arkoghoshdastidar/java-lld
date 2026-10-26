package com.parkinglot.spots;

import com.parkinglot.enums.ParkingSpotType;

public class Accessible extends ParkingSpot {
    public Accessible(String id) {
        super(id);
        this.spotType = ParkingSpotType.ACCESSIBLE;
    }
}