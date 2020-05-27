import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parking = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parking.put(carTicket, car);
        return carTicket;
    }

    public Car pickUp(CarTicket ticket) {
        return parking.get(ticket);
    }
}
