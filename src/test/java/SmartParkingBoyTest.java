import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SmartParkingBoyTest {
    @Test
    public void shouldParkToParkingLotWithMostAvailableSlots() {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));

        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingCompany(asList(first, second)));
        CarTicket ticket = parkingBoy.park(new Car("123"));
        assertEquals(1, ticket.getParkingLotId());
    }

    @Test
    public void shouldPickUpCarSuccessfullyGivenTicket() {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));

        Car myCar = new Car("123");

        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingCompany(asList(first, second)));
        CarTicket ticket = parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(ticket);
        assertEquals(myCar, result);
    }

    @Test
    public void shouldNotPickUpCarWithoutTicket() {
        ParkingLot first = new ParkingLot(1, 2);
        ParkingLot second = new ParkingLot(2, 3);
        second.park(new Car("123"));
        second.park(new Car("234"));

        Car myCar = new Car("123");

        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingCompany(asList(first, second)));
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


        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingCompany(asList(first, second)));
        Car result = parkingBoy.pickup(new CarTicket(1));
        assertNull(result);
    }
}
