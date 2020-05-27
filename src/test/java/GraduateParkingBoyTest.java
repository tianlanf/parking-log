import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class GraduateParkingBoyTest {
    @Test
    public void shouldParkToFirstParkingLot() throws Throwable {
        ParkingLot firstParkingLot = new ParkingLot(2);
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(firstParkingLot, new ParkingLot(3))));
        Car mycar = new Car("123");

        CarTicket ticket = parkingBoy.park(mycar);

        assertNotNull(ticket);
        assertEquals(mycar, firstParkingLot.pickUp(ticket));
    }

    @Test
    public void shouldParkToFirstAvailableParkingLot() throws Throwable {
        ParkingLot secondParkingLot = new ParkingLot(3);
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), secondParkingLot)));

        parkingBoy.park(new Car("123"));
        parkingBoy.park(new Car("234"));

        Car myCar = new Car("345");

        CarTicket ticket = parkingBoy.park(myCar);

        assertNotNull(ticket);
        assertEquals(myCar, secondParkingLot.pickUp(ticket));
    }


    @Test
    public void shouldThrowExceptionWhenAllParkingLotsAreFull() throws Throwable {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(1), new ParkingLot(1))));

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
    public void shouldPickUpCarFromFirstParkingLotSuccessfully() throws Throwable {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), new ParkingLot(3))));
        Car myCar = new Car("123");

        CarTicket ticket = parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(ticket);

        assertEquals(myCar, result);
    }

    @Test
    public void shouldPickUpCarFromOtherParkingLotSuccessfully() throws Throwable {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), new ParkingLot(3))));

        parkingBoy.park(new Car("123"));
        parkingBoy.park(new Car("234"));

        Car myCar = new Car("345");

        CarTicket ticket = parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(ticket);

        assertEquals(result, myCar);
    }

    @Test
    public void shouldNotPickUpCarWithoutTicket() throws Throwable {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), new ParkingLot(3))));
        Car myCar = new Car("123");

        parkingBoy.park(myCar);
        Car result = parkingBoy.pickup(null);

        assertNull(result);
    }

    @Test
    public void shouldNotPickUpCarWithFakeTicket() {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), new ParkingLot(3))));

        Car result = parkingBoy.pickup(new CarTicket());

        assertNull(result);
    }

}
