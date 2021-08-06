package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
//       private Car car;
//    private List<Car> cars;

    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

//    Ticket 1 -> ALice
//    Ticket 1 -> Alice
//    Ticket <-- relationships --> Car
//    Ticket(car), Car(ticket)


    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
//        this.car = car;
//        return null;
        return parkingTicket;
    }

//    public Car fetch(Car car) {
//        return null;
//    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkedPosition.get(parkingTicket);
    }
}
