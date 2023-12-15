package oepnv;

public class Passenger extends Human {
    private boolean sitting;
    private boolean hasValidTicket;

    public Passenger(String name, int age, boolean hasValidTicket) {
        super(name, age);
        this.sitting = false;
        this.hasValidTicket = hasValidTicket;
    }

    public void complain() {
        System.out.println(this.name + " rambles about Munich's ÖPNV.");
    }

    public void board(Vehicle v) {
        //TODO
    }

    public void exit() {
        //TODO
    }

    public boolean hasValidTicket() {
        return hasValidTicket;
    }
}
