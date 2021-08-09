package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    //Story 3
    @Test
    public void should_return_parking_ticket_when_park_by_a_standard_parking_boy_given_a_parking_lot_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetch_by_standard_parking_boy_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car actualCar = parkingBoy.fetch(parkingTicket);

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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket aliceParkingTicket = parkingBoy.park(aliceCar);
        ParkingTicket bobParkingTicket = parkingBoy.park(bobCar);
        Car actualAliceCar = parkingBoy.fetch(aliceParkingTicket);
        Car actualBobCar = parkingBoy.fetch(bobParkingTicket);

        //then
        assertEquals(aliceCar, actualAliceCar);
        assertEquals(bobCar, actualBobCar);
    }

    @Test
    public void should_throw_exception_with_error_message_when_fetch_by_standard_parking_boy_given_a_parking_lot_and_unrecognized_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(unrecognizedParkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_with_error_message_when_fetch_by_standard_parking_boy_given_a_parking_lot_and_used_parking_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(parkingTicket);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_park_by_standard_parking_boy_given_parking_without_any_position_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int x =0; x < 10; x++) {
            parkingLot.park(car);
        }

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(car));

        //then
        assertEquals("No available position.", exception.getMessage());
    }

    //Story 4
    @Test
    void should_return_ticket_and_park_car_to_first_parking_lot_when_park_given_a_standard_parking_boy_with_two_parking_lots_and_both_with_available_position_and_a_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
        assertTrue(parkingBoy.getParkingLots().get(0).getParkingSlotPosition().containsKey(parkingTicket));
    }
}
