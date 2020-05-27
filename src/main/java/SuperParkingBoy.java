import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy implements ParkingBoy {
    private ParkingCompany parkingCompany;
    public SuperParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    @Override
    public CarTicket park(Car car) throws Throwable {
        List<ParkingLot> parkingLots = parkingCompany.getParkingLots();
        parkingLots.sort(Comparator.comparingInt(ParkingLot::getAvailabilityInPercentage));

        ParkingLot parkingLot = parkingLots.get(parkingLots.size() - 1);
        if (parkingLot.isFull()) {
            throw new RuntimeException("All parking lots are full");
        }
        return parkingLot.park(car);
    }

    @Override
    public Car pickup(CarTicket ticket) {
        return null;
    }
}
