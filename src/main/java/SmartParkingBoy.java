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
        if (ticket == null) {
            return null;
        }
        ParkingLot parkingLot = parkingCompany.getParkingLots().stream()
                .filter(lot -> lot.getId() == ticket.getParkingLotId())
                .findFirst().orElse(null);
        if (parkingLot != null) {
            return parkingLot.pickUp(ticket);
        } else {
            return null;
        }
    }
}
