public class GraduateParkingBoy {
    private ParkingCompany parkingCompany;

    public GraduateParkingBoy(ParkingCompany parkingCompany) {
        this.parkingCompany = parkingCompany;
    }

    public CarTicket park(Car car) {
        ParkingLot parkingLot = parkingCompany.getParkingLots().stream().
                filter(lot -> !lot.isFull()).findFirst().get();
        return parkingLot.park(car);
    }
}
