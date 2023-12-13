package oepnv;

import java.util.Objects;

public class Driver extends OEPNVEmployee implements MakeAnnouncements {
    private DriversLicense[] driversLicenses;

    public Driver(String name, int age, int salary, DriversLicense[] driversLicenses) {
        super(name, age, salary);
        this.driversLicenses = driversLicenses;
    }

    public void drive(Vehicle v) {
        System.out.println(name + " is now driving a " + v.lineNumber);
    }

    @Override
    public void strike() {
        System.out.println(name + " goes on strike!");
    }

    @Override
    public void announce(String message) {
        System.out.println("Attention U-Bahn passengers: " + message);
    }

    public boolean isLicensedFor(Vehicle v) {
        for (DriversLicense dl : driversLicenses) {
            if (dl == DriversLicense.BUS_LICENSE && v instanceof Bus
            || dl == DriversLicense.U_BAHN_LICENSE && v instanceof UBahn
            || dl == DriversLicense.S_BAHN_LICENSE && v instanceof SBahn) {
                return true;
            }
        }
        return false;
    }
}
