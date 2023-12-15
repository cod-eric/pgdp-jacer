package oepnv;

public class TicketInspector extends OEPNVEmployee implements MakeAnnouncements {
    private int numberOfFinesHandedOut;

    public TicketInspector(String name, int age, int salary){
        super(name, age, salary);
    }

    @Override
    public void strike() {
        System.out.println("No ticket inspection today, y'all can ride for free!");
    }

    public int inspectTickets(Vehicle v) {
        announce("Attention everyone, this is a ticket inspection. Please keep your tickets at hand and let me take a quick look.");
        int finesToday = 0;
        for (Passenger p : v.getPassengers()) {
            if (!p.hasValidTicket()) {
                finesToday++;
            }
        }
        numberOfFinesHandedOut += finesToday;
        return finesToday;
    }

    @Override
    public void announce(String message) {
        MakeAnnouncements.super.announce("Ticket Inspector says: " + message);
    }

    public int getNumberOfFinesHandedOut() {
        return numberOfFinesHandedOut;
    }
}
