import java.util.List;

public class ParkingCompany {
    private List<ParkingLot> parkingLots;

    public ParkingCompany(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
