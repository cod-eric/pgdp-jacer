import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Technician extends OEPNVEmployee {
    private List<String> knownTools;

    public Technician(String name, int age, int salary, List<String> alreadyKnownTools) {
        super(name, age, salary);
        knownTools = new ArrayList<>(alreadyKnownTools);
    }

    public boolean routineCheck(Line l) {
        return false;
    }

    public boolean routineCheck(Track t) {
        return true;
    }

    public boolean fix(Line l) {
        System.out.println("*Clong*, *clong*.");
        return true;
    }

    public boolean fix(Track t) {
        System.out.println("*Clong*, *clong* in the distance.");
        return true;
    }

    public List<String> getKnownTools() {
        return knownTools;
    }

    public void learnTool(String tool) {
        knownTools.add(tool);
    }

    @Override
    public void strike() {
        System.out.println("Today, I'm fixing my pay, tomorrow we can talk about that defect line/track.");
    }
}
