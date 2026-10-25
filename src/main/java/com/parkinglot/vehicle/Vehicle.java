package com.parkinglot.vehicle;

public abstract class Vehicle {
    private String licenseNumber;
    private ParkingTicket ticket;

    public Vehicle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}