public class Driver extends OEPNVEmployee implements MakeAnnouncements {
    private DriverLicense[] driverLicenses;

    public Driver(String name, int age, int salary, DriverLicense[] driverLicenses) {
        super(name, age, salary);
        this.driverLicenses = driverLicenses;
    }

    public void drive(Vehicle v) {
        System.out.println(name + " is now driving a " + v.line);
        //TODO
    }

    @Override
    public void strike() {
        System.out.println(name + " goes on strike!");
    }

    @Override
    public void announce(String message) {
        System.out.println("Attention U-Bahn passengers: " + message);
    }
}
