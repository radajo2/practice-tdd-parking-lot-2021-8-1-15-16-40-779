package com.parkinglot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    //Story 1
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

    @Test
    public void should_return_nothing_when_fetch_given_a_parking_lot_and_wrong_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_when_fetch_given_a_parking_lot_and_used_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(new Car());
        parkingLot.fetch(parkingTicket);

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_nothing_when_park_given_parking_without_any_position_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        for (int x =0; x < 10; x++) {
          parkingLot.park(new Car());
        }

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }

    //Story 2
    @Test
    public void should_throw_exception_with_error_message_when_fetch_given_a_parking_lot_and_unrecognized_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_with_error_message_when_fetch_given_a_parking_lot_and_used_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(new Car());
        parkingLot.fetch(parkingTicket);

        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_park_given_parking_without_any_position_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        for (int x =0; x < 10; x++) {
            parkingLot.park(car);
        }

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}
