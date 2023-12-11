import java.util.Arrays;
import java.util.Random;

public class Scheduler extends OEPNVEmployee implements MakeAnnouncements {
    public Scheduler(String name, int age, int salary) {
        super(name, age, salary);
    }

    @Override
    public void strike() {
        System.out.println(name + ": I am on strike! Who cares about the net plans?");
    }

    public String createNetPlan(Line[] linesInMunich, TrackSegment[] trackSegments) {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (Line l : linesInMunich) {
            sb.append(l).append(": -START- ");
            for (int i = 0; i < random.nextInt(trackSegments.length); i++) {
                sb.append(Arrays.toString(trackSegments[i].getCoordinates())).append(", ");
            }
            sb.append(" -END-\n");
        }
        return sb.toString();
    }

    public Line establishReplacementService(Line l) {
        Random random = new Random();
        System.out.println("Due to a delay on line " + l + ", we will establish a bus replacement.");
        return BusLine.values()[random.nextInt(BusLine.values().length)];
    }
}
