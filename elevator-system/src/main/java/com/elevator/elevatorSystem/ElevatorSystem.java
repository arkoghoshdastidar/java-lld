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
    private static ElevatorSystem instance;

    private ElevatorSystem(int ID, List<Floor> floors, List<ElevatorCar> elevators) {
        this.ID = ID;
        this.floors = floors;
        this.elevators = elevators;
    }

    public static ElevatorSystem getInstance(int ID, List<Floor> floors, List<ElevatorCar> elevators) {
        if(instance == null) {
            synchronized (ElevatorSystem.class) {
                if(instance == null) {
                    instance = new ElevatorSystem(ID, floors, elevators);
                    }
        }
        return instance;
    }

    public int getID() {
        return ID;
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }

    synchronized public void getNearestElevator(int floorNumber, Direction direction) {
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
            nearestElevator = getElevators().stream()
                    .filter(elevator -> {
                        return elevator.getState() != targetDirection && elevator.getState() != ElevatorState.IDLE;
                    }).max((e1, e2) -> {
                        int distance1 = Math.abs(e1.getCurrentFloor() - floorNumber);
                        int distance2 = Math.abs(e2.getCurrentFloor() - floorNumber);
                        return Integer.compare(distance1, distance2);
                    }).orElse(null);
        }

        nearestElevator.requestStop(floorNumber);

        System.out.println("Elevator " + nearestElevator.getID() + " is assigned to floor " + floorNumber + " for direction " + direction);
    }
}
