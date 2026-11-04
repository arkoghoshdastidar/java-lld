package com.elevator.floor;

import com.elevator.display.Display;
import com.elevator.panel.HallPanel;

import java.util.List;

public class Floor {
    private Integer floorNumber;
    private List<Display> displays;
    private HallPanel hallPanel;

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setDisplays(List<Display> displays) {
        this.displays = displays;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setHallPanel(HallPanel hallPanel) {
        this.hallPanel = hallPanel;
    }
}