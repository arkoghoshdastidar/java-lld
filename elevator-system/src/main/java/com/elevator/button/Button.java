package com.elevator.button;

abstract public class Button {
    private boolean pressed;

    public boolean pressDown() {
        pressed = true;
        return pressed;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void reset() {
        pressed = false;
    }
}