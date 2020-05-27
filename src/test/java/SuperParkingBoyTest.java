import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class SuperParkingBoyTest {
    @Test
    public void shouldParkToParkingLotWithHighestAvailability() throws Throwable {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        first.park(new Car("012"));
        second.park(new Car("123"));
        second.park(new Car("234"));

        SuperParkingBoy parkingBoy = new SuperParkingBoy(new ParkingCompany(asList(first, second)));
        CarTicket ticket = parkingBoy.park(new Car("345"));
        assertEquals(1, ticket.getParkingLotId());
    }

    @Test
    public void shouldThrowExceptionWhenAllParkingLotsAreFull() throws Throwable {
        ParkingBoy parkingBoy =
                new SuperParkingBoy(new ParkingCompany(asList(new ParkingLot(1, 1), new ParkingLot(2, 1))));

        parkingBoy.park(new Car("123"));
        parkingBoy.park(new Car("234"));

        try{
            parkingBoy.park(new Car("345"));
            fail();
        } catch (Exception e) {
            assertEquals("All parking lots are full", e.getMessage());
        }
    }


    @Test
    public void shouldPickUpCarSuccessfullyGivenTicket() throws Throwable {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));
        first.park(new Car("012"));

        Car myCar = new Car("345");

        SuperParkingBoy parkingBoy = new SuperParkingBoy(new ParkingCompany(asList(first, second)));
        CarTicket ticket = parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(ticket);
        assertEquals(myCar, result);
    }

    @Test
    public void shouldNotPickUpCarWithoutTicket() throws Throwable {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));

        Car myCar = new Car("123");

        SuperParkingBoy parkingBoy = new SuperParkingBoy(new ParkingCompany(asList(first, second)));
        parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(null);
        assertNull(result);
    }

    @Test
    public void shouldNotPickUpCarWithFakeTicket() {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));


        SuperParkingBoy parkingBoy = new SuperParkingBoy(new ParkingCompany(asList(first, second)));
        Car result = parkingBoy.pickup(new CarTicket(1));
        assertNull(result);
    }

}
