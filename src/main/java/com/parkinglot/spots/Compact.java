package com.parkinglot.spots;

import com.parkinglot.enums.ParkingSpotType;

public class Compact extends ParkingSpot {
    public Compact(String id) {
        super(id);
        this.spotType = ParkingSpotType.COMPACT;
    }
}