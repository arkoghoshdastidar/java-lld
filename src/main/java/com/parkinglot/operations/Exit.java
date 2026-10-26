package com.parkinglot.operations;

public class Exit {
    private String exitGateId;

    public Exit(String exitGateId) {
        this.exitGateId = exitGateId;
    }

    public boolean validateTicket(ParkingTicket ticket) {
        // Implement ticket validation logic here
        return true;
    }
}
