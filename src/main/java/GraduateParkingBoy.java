public class GraduateParkingBoy {
    private ParkingCompany parkingCompany;

    public GraduateParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    public CarTicket park(Car car) {
        ParkingLot parkingLot = parkingCompany.getParkingLots().get(0);
        return parkingLot.park(car);
    }
}
