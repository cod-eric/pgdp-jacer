import java.util.Objects;

public class Driver extends OEPNVEmployee implements MakeAnnouncements {
    private DriverLicense[] driverLicenses;

    public Driver(String name, int age, int salary, DriverLicense[] driverLicenses) {
        super(name, age, salary);
        this.driverLicenses = driverLicenses;
    }

    public void drive(Vehicle v) {
        System.out.println(name + " is now driving a " + v.getLINE());
    }

    @Override
    public void strike() {
        System.out.println(name + " goes on strike!");
    }

    @Override
    public void announce(String message) {
        System.out.println("Attention U-Bahn passengers: " + message);
    }

    public boolean isLicensedFor(Line l) {
        for (DriverLicense dl : driverLicenses) {
            if (Objects.equals(dl.toString().split("L")[0], l.toString().split("L")[0])) {
                return true;
            }
        }
        return false;
    }
}
