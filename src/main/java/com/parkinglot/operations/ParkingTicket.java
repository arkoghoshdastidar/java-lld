package com.parkinglot.operations;

import com.parkinglot.enums.ParkingSpotType;
import com.parkinglot.enums.TicketStatus;
import com.parkinglot.payment.Payment;
import com.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    private Integer ticketNo;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private Vehicle vehicle;
    private ParkingSpotType parkingSpotType;
    private Payment payment;
    private Entrance entrance;
    private Exit exit;

    public ParkingTicket(Integer ticketNo, Vehicle vehicle, Entrance entrance) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ISSUED;
        this.entrance = entrance;
        this.vehicle.assignTicket(this);
        this.setParkingSpot(vehicle);
    }

    private void updateStatus(TicketStatus status) {
        this.status = status;
    }

    public void updateExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public void updatePayment(Payment payment) {
        this.payment = payment;
    }

    public void updateExit(Exit exit) {
        this.exit = exit;
    }

    private void setParkingSpot(Vehicle vehicle) {
        if(vehicle instanceof com.parkinglot.vehicle.Car) {
           this.parkingSpotType = ParkingSpotType.COMPACT;
        } else if(vehicle instanceof com.parkinglot.vehicle.Truck) {
            this.parkingSpotType = ParkingSpotType.LARGE;
        } else if(vehicle instanceof com.parkinglot.vehicle.MotorCycle) {
            this.parkingSpotType = ParkingSpotType.MOTROCYCLE;
        } else if(vehicle instanceof com.parkinglot.vehicle.Van) {
            this.parkingSpotType = ParkingSpotType.LARGE;
        } else {
            this.parkingSpotType = ParkingSpotType.ACCESSIBLE;
        }
    }
}