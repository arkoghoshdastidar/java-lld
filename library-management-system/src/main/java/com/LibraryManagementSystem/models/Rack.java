package com.LibraryManagementSystem.models;

public class Rack {
    private String identifier;
    private boolean isOccupied;

    public Rack(String identifier) {
        this.identifier = identifier;
        this.isOccupied = true;
    }
}
