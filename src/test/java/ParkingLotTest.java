import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ParkingLotTest {
    @Test
    public void shouldGetTicketUponParking() {
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = parkingLot.park(new Car());
        assertNotNull(ticket);
    }
}
