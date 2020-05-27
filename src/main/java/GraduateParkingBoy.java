import java.util.function.Supplier;

public class GraduateParkingBoy {
    private ParkingCompany parkingCompany;

    public GraduateParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    public CarTicket park(Car car) throws Throwable {
        ParkingLot parkingLot = parkingCompany.getParkingLots().stream().
                filter(lot -> !lot.isFull()).findFirst()
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("All parking lots are full"));
        return parkingLot.park(car);
    }

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
