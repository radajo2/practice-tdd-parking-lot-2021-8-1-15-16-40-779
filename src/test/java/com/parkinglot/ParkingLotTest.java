package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
//    [] Case1
//    Given a parking lot, and a car
//    When park the car
//    Then return a parking ticket.
    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
        ParkingTicket bobParkingTicket = parkingLot.park(bobCar);

        //when
        Car actualAliceCar = parkingLot.fetch(aliceParkingTicket);
        Car actualBobCar = parkingLot.fetch(bobParkingTicket);

        //then
        assertEquals(aliceCar, actualAliceCar);
        assertEquals(bobCar, actualBobCar);
    }

//    @Test
//    public void should_return_nothing_when_car_fetch_twice_given_a_parking_lot(){
//
//        ParkingLot parkingLot = new ParkingLot();
//        Car aliceCar = new Car();
//        Car bobCar = new Car();
//        ParkingTicket aliceParkingTicket = parkingLot.park(aliceCar);
//        ParkingTicket bobParkingTicket = parkingLot.park(bobCar);
//
//        //when
//        Car actualAliceCar = parkingLot.fetch(aliceParkingTicket);
//        Car actualBobCar = parkingLot.fetch(bobParkingTicket);
//
//        //then
//        assertEquals(aliceCar, actualAliceCar);
//        assertEquals(bobCar, actualBobCar);
//    }


}
