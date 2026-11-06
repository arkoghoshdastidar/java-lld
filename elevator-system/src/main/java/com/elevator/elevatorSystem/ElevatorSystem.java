package com.elevator.elevatorSystem;

import com.elevator.elevatorCar.ElevatorCar;
import com.elevator.enums.ElevatorState;
import com.elevator.floor.Floor;
import com.elevator.enums.Direction;
import java.util.List;

public class ElevatorSystem {
    private int ID;
    private List<Floor> floors;
    private List<ElevatorCar> elevators;

    public ElevatorSystem(int ID, List<Floor> floors, List<ElevatorCar> elevators) {
        this.ID = ID;
        this.floors = floors;
        this.elevators = elevators;
    }

    public int getID() {
        return ID;
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }

    public void getNearestElevator(int floorNumber, Direction direction) {
        ElevatorState targetDirection = (direction == Direction.UP)? ElevatorState.UP : ElevatorState.DOWN;
        ElevatorCar nearestElevator = getElevators().stream()
                .filter(elevator -> {
                    return elevator.getState() == targetDirection || elevator.getState() == ElevatorState.IDLE;
                }).min((e1, e2) -> {
                    int distance1 = Math.abs(e1.getCurrentFloor() - floorNumber);
                    int distance2 = Math.abs(e2.getCurrentFloor() - floorNumber);
                    return Integer.compare(distance1, distance2);
                }).orElse(null);

        if(nearestElevator == null) {
            System.out.println("No available elevator found for floor " + floorNumber + " and direction " + direction);
            return;
        }

        nearestElevator.requestStop(floorNumber);

        System.out.println("Elevator " + nearestElevator.getID() + " is assigned to floor " + floorNumber + " for direction " + direction);
    }
}
