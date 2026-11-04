package com.elevator.button;
import com.elevator.enums.Direction;
import com.elevator.floor.Floor;

public class HallButton extends Button {
    private Direction direction;
    private ElevatorSystem system;
    private Floor floor;

    public HallButton(Direction direction) {
        this.setDirection(direction);
    }

    public void setElevatorSystem(ElevatorSystem system) {
        if(this.system == null) {
            this.system = system;
        }
    }

    public void setFloor(Floor floor) {
        if(this.floor == null) {
            this.floor = floor;
        }
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