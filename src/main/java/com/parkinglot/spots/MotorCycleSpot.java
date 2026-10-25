package com.parkinglot.spots;

import com.parkinglot.enums.ParkingSpotType;

public class MotorCycleSpot extends ParkingSpot {

    public MotorCycleSpot(String id) {
        super(id);
        this.spotType = ParkingSpotType.MOTROCYCLE;
    }
}