package com.parkinglot.boards;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.spots.ParkingSpot;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DisplayBoard {
    private String id;
    private Map<ParkingSpotType, ArrayList<ParkingSpot>> parkingSpots;

    public DisplayBoard(String id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpotType parkingSpotType, ParkingSpot parkingSpot) {
        if(parkingSpots.get(parkingSpotType) == null) {
            ArrayList<ParkingSpot> spots = new ArrayList<>();
            parkingSpots.put(parkingSpotType, spots);
        }
        parkingSpots.get(parkingSpotType).add(parkingSpot);
    }

    public boolean removeParkingSpot(ParkingSpotType parkingSpotType, ParkingSpot parkingSpot) {
        ArrayList<ParkingSpot> spots = parkingSpots.get(parkingSpotType);
        if(spots == null) {
            return false;
        }
        return parkingSpots.get(parkingSpotType).stream().filter(
                spot -> spot.getId().equals(parkingSpot.getId())
        ).findFirst().map(spots::remove).orElse(false);
    }
}