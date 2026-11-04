package com.elevator.button;

public class ElevatorButton extends Button {
    private Floor destinationFloor;

    ElevatorButton(Floor destinationFloor) {
        this.destinationFloor = destinationFloor;

    }

    public Floor getDestinationFloor() {
        return destinationFloor;
    }
}