package com.elevator.panel;

import com.elevator.button.DoorButton;
import com.elevator.button.ElevatorButton;
import com.elevator.button.EmergencyButton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {
    private List<ElevatorButton> elevatorButtons;
    private DoorButton openButton;
    private DoorButton closeButton;
    private EmergencyButton emergencyButton;

    public ElevatorPanel(List<Floor> floors) {
        this.elevatorButtons = floors.stream().map(ElevatorButton::new).toList();
        openButton = new DoorButton();
        closeButton = new DoorButton();
        emergencyButton = new EmergencyButton();
    }
}