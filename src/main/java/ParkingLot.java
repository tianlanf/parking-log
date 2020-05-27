import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final int id;
    private Map<CarTicket, Car> parking = new HashMap<>();

    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (parking.size() < capacity) {
            CarTicket carTicket = new CarTicket(id);
            parking.put(carTicket, car);
            return carTicket;
        } else {
            throw new RuntimeException("parking lot is already full");
        }
    }

    public Car pickUp(CarTicket ticket) {
        return parking.get(ticket);
    }

    public boolean isFull() {
        return capacity == parking.size();
    }

    public int getAvailableSlotsNumber() {
        return capacity - parking.size();
    }

    public int getId() {
        return id;
    }
}
