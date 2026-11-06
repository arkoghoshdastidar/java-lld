package com.elevator.elevatorCar;

import com.elevator.display.Display;
import com.elevator.door.Door;
import com.elevator.enums.ElevatorState;
import com.elevator.floor.Floor;
import com.elevator.panel.ElevatorPanel;

import java.util.List;
import java.util.PriorityQueue;

public class ElevatorCar {
    private int ID;
    private int currentFloor;
    private ElevatorState state;
    private Door door;
    private Display display;
    private ElevatorPanel elevatorPanel;
    private PriorityQueue<Integer> maxPriorityQueue;
    private PriorityQueue<Integer> minPriorityQueue;

    ElevatorCar(List<Floor> floors) {
        currentFloor = 0;
        elevatorPanel = new ElevatorPanel(floors);
        door = new Door();
        display = new Display(1, 0);
        maxPriorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minPriorityQueue = new PriorityQueue<>();
    }

    public boolean requestStop(int floorNumber) {
        if(state == ElevatorState.UP && floorNumber > currentFloor && !minPriorityQueue.contains(floorNumber)) {
            minPriorityQueue.add(floorNumber);
            return true;
        } else if(state == ElevatorState.DOWN && floorNumber < currentFloor && !maxPriorityQueue.contains(floorNumber)) {
            maxPriorityQueue.add(floorNumber);
            return true;
        }else if (state == ElevatorState.IDLE) {
            if(floorNumber > currentFloor) {
                state = ElevatorState.UP;
                minPriorityQueue.add(floorNumber);
                return true;
            } else if(floorNumber < currentFloor) {
                state = ElevatorState.DOWN;
                maxPriorityQueue.add(floorNumber);
                return true;
            }
        }
        return false;
    }

    public void move() {
        if(state == ElevatorState.IDLE) {
            System.out.println("Elevator is idle at floor " + currentFloor);
        }else if (state == ElevatorState.UP) {
            System.out.println("Elevator is moving UP");
        }else if(state == ElevatorState.DOWN) {
            System.out.println("Elevator is moving DOWN");
        }else {
            System.out.println("Elevator is in maintenance mode");
        }
    }

    public void stop() {
        if(state == ElevatorState.UP && currentFloor == minPriorityQueue.peek()){
            minPriorityQueue.poll();
            if(minPriorityQueue.isEmpty()) {
                state = ElevatorState.IDLE;
            }
            openDoor();
        }else if(state == ElevatorState.DOWN && currentFloor == maxPriorityQueue.peek()){
            maxPriorityQueue.poll();
            if(maxPriorityQueue.isEmpty()) {
                state = ElevatorState.IDLE;
            }
            openDoor();
        }else if(state == ElevatorState.IDLE) {
            System.out.println("Elevator is already idle at floor " + currentFloor);
        }
    }

    public boolean openDoor() {
        door.open();
        return door.isOpen();
    }

    public boolean closeDoor() {
        door.close();
        return !door.isOpen();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }
}
