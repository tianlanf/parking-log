import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

    @Test
    public void shouldNotGetMyCarWithoutMyTicket() {
        Car myCar = new Car("123");

        parkingLot.park(myCar);
        Car result = parkingLot.pickUp(null);

        assertNull(result);
    }

    @Test
    public void shouldNotGetCarWithFakeTicket() {
        Car result = parkingLot.pickUp(new CarTicket());
        assertNull(result);
    }

}
