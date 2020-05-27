import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotTest {

    private final ParkingLot parkingLot = new ParkingLot();

    @Test
    public void shouldGetTicketUponParking() {
        CarTicket ticket = parkingLot.park(new Car("123"));
        assertNotNull(ticket);
    }

    @Test
    public void shouldGetMyCarWithMyTicket() {
        Car myCar = new Car("123");

        CarTicket ticket = parkingLot.park(myCar);
        Car result = parkingLot.pickUp(ticket);

        assertNotNull(result);
        assertEquals(myCar, result);
    }
}
