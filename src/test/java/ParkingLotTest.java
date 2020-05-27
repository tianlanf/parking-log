import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class ParkingLotTest {

    private final ParkingLot parkingLot = new ParkingLot(1, 2);

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
        Car result = parkingLot.pickUp(new CarTicket(1));
        assertNull(result);
    }

    @Test
    public void shouldNotParkWhenParkingLotIsFull() {
        parkingLot.park(new Car("123"));
        parkingLot.park(new Car("345"));
        try {
            parkingLot.park(new Car("456"));
            fail();
        } catch (Exception e) {
            assertEquals("parking lot is already full", e.getMessage());
        }
    }
}
