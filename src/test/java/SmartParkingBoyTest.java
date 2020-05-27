import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

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
}
