package com.LibraryManagementSystem.models;

public class Rack {
    private String identifier;
    private boolean isOccupied;

    public Rack(String identifier) {
        this.identifier = identifier;
        this.isOccupied = true;
    }

    public boolean isRackOccupied() {
        return isOccupied;
    }

    public void checkoutBook() {
        if(!isOccupied) {
            System.out.println("The rack is empty, no book present in the rack");
            return;
        }
        isOccupied = false;
    }

    public void restore() throws Exception{
        if(isOccupied) {
            throw new Exception("The rack is already containing a book");
        }
        isOccupied = true;
    }
}
