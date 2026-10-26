package com.parkinglot.account;

import com.parkinglot.boards.DisplayBoard;
import com.parkinglot.models.Person;
import com.parkinglot.operations.Entrance;
import com.parkinglot.operations.Exit;
import com.parkinglot.spots.ParkingSpot;

public class Admin extends Account {
    public Admin(String username, String password, Person person) {
        super(username, password, person);
    }

    public boolean addParkingSpot(ParkingSpot spot, Integer floor) {
        //business logic
        return false;
    }

    public boolean addDisplayBoard(DisplayBoard board, Integer floor) {
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