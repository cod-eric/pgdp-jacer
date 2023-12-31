package oepnv;

import oepnv.linenumbers.BusLineNumber;
import oepnv.linenumbers.SBahnLineNumber;

import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public abstract class Vehicle implements Delayable {
    private Line line;
    private byte numberOfWheels;
    private Date yearOfConstruction;
    private Driver driver;
    private Deque<Passenger> passengers;

    public Vehicle(Line line) {
        this.line = line;
        this.numberOfWheels = (byte)(line.lineNumber instanceof BusLineNumber ? 6 : line.lineNumber instanceof SBahnLineNumber ? 28 : 16);
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

    public Line getLine() {
        return line;
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
