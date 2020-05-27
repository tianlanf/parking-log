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

        ParkingLot parkingLot = parkingLots.get(parkingLots.size() - 1);
        if (parkingLot.isFull()) {
            throw new RuntimeException("All parking lots are full");
        }
        return parkingLot.park(car);
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
