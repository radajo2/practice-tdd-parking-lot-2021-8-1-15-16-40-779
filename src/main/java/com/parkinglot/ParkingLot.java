package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
//       private Car car;
//    private List<Car> cars;

    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private int slotNumber = 0;
    private int maxSlotNumber = 10;
//    Ticket 1 -> ALice
//    Ticket 1 -> Alice
//    Ticket <-- relationships --> Car
//    Ticket(car), Car(ticket)

    public ParkingTicket park(Car car) {
        if(slotNumber < maxSlotNumber){
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            slotNumber++;
//        this.car = car;
//        return null;
            return parkingTicket;
        }
        return null;
    }

//    public Car fetch(Car car) {
//        return null;
//    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket.isUsed()){
            parkingTicket.setUsed();
            return parkedPosition.get(parkingTicket);
        }
        return null;
    }
}
