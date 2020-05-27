public interface ParkingBoy {
    CarTicket park(Car car) throws Throwable;

    Car pickup(CarTicket ticket);
}
