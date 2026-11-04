package com.elevator.button;
import com.elevator.enums.Direction;

public class HallButton extends Button {
    private Direction direction;
    private ElevatorSystem system;
    private Floor floor;

    public HallButton(Direction direction) {
        this.setDirection(direction);
    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        if(this.direction == null) {
            this.direction = direction;
        }
    }

    public boolean press() {
        if(super.isPressed()) {
            return false;
        }
        super.pressDown();
        if(system != null && floor != null) {
            system.getNearestElevator(floor.getFloorNumber(), direction);
        }else{
            System.out.println("ElevatorSystem or Floor is not set for HallButton.");
        }
        return super.isPressed();
    }
}