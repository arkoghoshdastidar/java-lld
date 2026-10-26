package com.parkinglot.operations;

import com.parkinglot.vehicle.Vehicle;

public class Entrance {
    private String entranceGateId;

    public Entrance(String entranceGateId) {
        this.entranceGateId = entranceGateId;
    }

    public boolean generateEntryTicket(Vehicle vehicle) {
        // Implement ticket generation logic here
        return true;
    }
}
