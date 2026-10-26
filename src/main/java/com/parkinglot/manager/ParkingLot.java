package com.parkinglot.manager;
import com.parkinglot.boards.DisplayBoard;
import com.parkinglot.operations.Entrance;
import com.parkinglot.operations.Exit;
import com.parkinglot.operations.ParkingTicket;
import com.parkinglot.spots.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static volatile ParkingLot instance = null;
    private String id;
    private String name;
    private String address;
    private Map<String, ParkingSpot> parkingSpots;
    private Map<String, Entrance> entrances;
    private Map<String, Exit> exits;
    private Map<String, DisplayBoard> displayBoards;
    private Map<String, ParkingTicket> activeTickets;

    private ParkingLot(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.parkingSpots = new HashMap<>();
        this.entrances = new HashMap<>();
        this.exits = new HashMap<>();
        this.displayBoards = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance(String id, String name, String address) {
        if (instance == null) {
            instance = new ParkingLot(id, name, address);
        }
        return instance;
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot has not been initialized yet!");
        }
        return instance;
    }

    public synchronized boolean addParkingSpot(String spotId, ParkingSpot spot) {
        if (parkingSpots.containsKey(spotId)) {
            return false;
        }
        parkingSpots.put(spotId, spot);
        return true;
    }

    public synchronized boolean addEntrance(String entranceId, Entrance entrance) {
        if (entrances.containsKey(entranceId)) {
            return false;
        }
        entrances.put(entranceId, entrance);
        return true;
    }

    public synchronized boolean addExit(String exitId, Exit exit) {
        if (exits.containsKey(exitId)) {
            return false;
        }
        exits.put(exitId, exit);
        return true;
    }

    public synchronized ParkingTicket getParkingTicket(Vehicle vehicle) {
        // business logic
        return null;
    }

    public synchronized boolean isFull(Vehicle type) {
        // business logic
        return false;
    }
}