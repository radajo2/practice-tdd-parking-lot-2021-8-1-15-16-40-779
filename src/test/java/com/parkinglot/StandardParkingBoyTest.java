package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_by_a_standard_parking_boy_given_a_parking_lot_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetch_by_standard_parking_boy_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        Car actualCar = standardParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_right_car_when_fetch_twice_by_standard_parking_boy_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();

        //when
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket aliceParkingTicket = standardParkingBoy.park(aliceCar);
        ParkingTicket bobParkingTicket = standardParkingBoy.park(bobCar);
        Car actualAliceCar = standardParkingBoy.fetch(aliceParkingTicket);
        Car actualBobCar = standardParkingBoy.fetch(bobParkingTicket);

        //then
        assertEquals(aliceCar, actualAliceCar);
        assertEquals(bobCar, actualBobCar);
    }

    @Test
    public void should_throw_exception_with_error_message_when_fetch_by_standard_parking_boy_given_a_parking_lot_and_unrecognized_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_with_error_message_when_fetch_by_standard_parking_boy_given_a_parking_lot_and_used_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket parkingTicket = standardParkingBoy.park(new Car());
        standardParkingBoy.fetch(parkingTicket);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_park_by_standard_parking_boy_given_parking_without_any_position_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        for (int x =0; x < 10; x++) {
            parkingLot.park(car);
        }

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }
}
