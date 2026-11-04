package com.elevator.display;

import com.elevator.enums.Direction;

public class Display {
    private Integer id;
    private Integer floorNumber;
    private Integer elevatorPosition;
    private Direction direction;

    public Display(Integer id, Integer floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
    }

    public void updateElevatorPosition(Integer elevatorPosition) {
        this.elevatorPosition = elevatorPosition;
    }

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }

    public void showStatus() {
        System.out.println("Floor: " + floorNumber + ", Elevator Position: " + elevatorPosition + ", Direction: " + direction);
    }

}