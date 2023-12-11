import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public abstract class Vehicle implements Delayable {
    private final Line LINE;
    private byte numberOfWheels;
    private Date yearOfConstruction;
    private Driver driver;
    private Deque<Passenger> passengers;

    public Vehicle(Line line) {
        this.LINE = line;
        this.numberOfWheels = (byte)(LINE instanceof BusLine ? 6 : LINE instanceof SBahnLine ? 28 : 16);
        this.yearOfConstruction = new Date();   // initializes Date with the current date
        this.passengers = new LinkedList<>();
    }

    @Override
    public void delay(int duration, Reason reason) {
        driver.announce("Due to " + reason.toString() + ", we will be delayed by " + duration + " minutes.");
    }

    public abstract void move();
    public abstract void openDoors();
    public abstract void closeDoors();

    public Deque<Passenger> getPassengers() {
        return passengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public Line getLINE() {
        return LINE;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public void addPassengers(Collection<Passenger> ps) {
        for (Passenger p : ps) {
            addPassenger(p);
        }
    }
}
