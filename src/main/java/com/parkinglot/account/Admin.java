package com.parkinglot.account;

import com.parkinglot.models.Person;
import com.parkinglot.spots.ParkingSpot;

public class Admin extends Account {
    public Admin(String username, String password, Person person) {
        super(username, password, person);
    }

    public boolean addParkingSpot(ParkingSpot spot, int floor) {
        //business logic
        return false;
    }

    public boolean addDisplayBoard(DisplayBoard board, int floor) {
        //business logic
        return false;
    }

    public boolean addEntrance(Entrance entrance) {
        //business logic
        return false;
    }

    public boolean addExit(Exit exit) {
        //business logic
        return false;
    }
}