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
        elevatorPanel = new ElevatorPanel(floors);
        door = new Door();
        display = new Display(1, 0);
        maxPriorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minPriorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }


}
