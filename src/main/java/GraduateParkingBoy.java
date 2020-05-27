import java.util.function.Supplier;

public class GraduateParkingBoy implements ParkingBoy{
    private ParkingCompany parkingCompany;

    public GraduateParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    @Override
    public CarTicket park(Car car) throws Throwable {
        ParkingLot parkingLot = parkingCompany.getParkingLots().stream().
                filter(lot -> !lot.isFull()).findFirst()
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("All parking lots are full"));
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
