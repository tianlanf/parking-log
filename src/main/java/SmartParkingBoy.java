import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy implements ParkingBoy {
    private ParkingCompany parkingCompany;

    public SmartParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> parkingLots = parkingCompany.getParkingLots();
        parkingLots.sort(Comparator.comparingInt(ParkingLot::getAvailableSlotsNumber));

        return parkingLots.get(parkingLots.size() -1).park(car);
    }

    @Override
    public Car pickup(CarTicket ticket) {
        return null;
    }
}
