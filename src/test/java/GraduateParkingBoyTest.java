import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;

public class GraduateParkingBoyTest {
    @Test
    public void shouldParkToFirstParkingLot() {
        GraduateParkingBoy parkingBoy =
                new GraduateParkingBoy(new ParkingCompany(asList(new ParkingLot(2), new ParkingLot(3))));

        CarTicket ticket = parkingBoy.park(new Car("123"));
        assertNotNull(ticket);
    }
}
