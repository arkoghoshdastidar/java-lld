package com.elevator.panel;
import com.elevator.button.HallButton;
import com.elevator.enums.Direction;

public class HallPanel {
    private HallButton upButton;
    private HallButton downButton;
    private Floor floor;

    public HallPanel(Floor floor) {
        upButton = new HallButton(Direction.UP);
        downButton = new HallButton(Direction.DOWN);
        this.floor = floor;
    }
}