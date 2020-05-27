import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<CarTicket, Car> parking = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (parking.size() < capacity) {
            CarTicket carTicket = new CarTicket();
            parking.put(carTicket, car);
            return carTicket;
        } else {
            throw new RuntimeException("parking lot is already full");
        }
    }

    public Car pickUp(CarTicket ticket) {
        return parking.get(ticket);
    }
}
