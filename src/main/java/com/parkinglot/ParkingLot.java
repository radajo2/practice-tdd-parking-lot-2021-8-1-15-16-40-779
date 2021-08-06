package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private int slotNumber = 0;
    private int maxSlotNumber = 10;

    public ParkingTicket park(Car car) {
        if(slotNumber < maxSlotNumber){
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            slotNumber++;
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }
}
