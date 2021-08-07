package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final static int DEFAULT_CAPACITY = 10;
    private Map<ParkingTicket, Car> parkedPosition;
    private int capacity;

    public ParkingLot(){
        this(DEFAULT_CAPACITY);
    }

    public ParkingLot(int capacity){
        parkedPosition = new HashMap<>();
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if(isFull()){
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    private boolean isFull() {
        return parkedPosition.size() >= capacity;
    }
}
