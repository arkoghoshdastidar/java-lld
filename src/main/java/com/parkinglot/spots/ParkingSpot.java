package com.parkinglot.spots;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String id;
    Vehicle vehicle;
    boolean isFree;
    ParkingSpotType spotType;

    public ParkingSpot(String id) {
        this.id = id;
        this.isFree = true;
        this.vehicle = null;
    }

    public Vehicle assignVehicle(Vehicle vehicle) {
        if(isFree) {
            this.isFree = false;
            this.vehicle = vehicle;
        }else{
            System.out.println("ParkingSpot is already free");
            return null;
        }
        return vehicle;
    }

    public void removeVehicle() {
        this.isFree = true;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public String getId() {return id;}
}