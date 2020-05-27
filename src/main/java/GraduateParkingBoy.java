import java.util.List;
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
        List<ParkingLot> parkingLots = parkingCompany.getParkingLots();
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.pickUp(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}
