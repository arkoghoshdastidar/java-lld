package com.elevator.door;

import com.elevator.enums.DoorState;

public class Door {
    private DoorState doorState;

    public Door() {
        this.doorState = DoorState.CLOSED;
    }

    public boolean isOpen() {
        return doorState == DoorState.OPEN;
    }

    public void close() {
        if (doorState == DoorState.OPEN) {
            doorState = DoorState.CLOSED;
        }
    }

    public void open() {
        if (doorState == DoorState.CLOSED) {
            doorState = DoorState.OPEN;
        }
    }

    public DoorState getDoorState() {
        return doorState;
    }
}
