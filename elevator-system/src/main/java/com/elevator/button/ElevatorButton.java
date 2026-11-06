package com.elevator.button;

import com.elevator.floor.Floor;

public class ElevatorButton extends Button {
    private Floor destinationFloor;

    public ElevatorButton(Floor destinationFloor) {
        this.destinationFloor = destinationFloor;

    }

    public Floor getDestinationFloor() {
        return destinationFloor;
    }
}