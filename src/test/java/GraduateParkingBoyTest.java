import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GraduateParkingBoyTest {
    @Test
    public void shouldParkToFirstParkingLot() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(firstParkingLot, new ParkingLot(3))));
        Car mycar = new Car("123");

        CarTicket ticket = parkingBoy.park(mycar);

        assertNotNull(ticket);
        assertEquals(mycar, firstParkingLot.pickUp(ticket));
    }

    @Test
    public void shouldParkToFirstAvailableParkingLot() {
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
}
