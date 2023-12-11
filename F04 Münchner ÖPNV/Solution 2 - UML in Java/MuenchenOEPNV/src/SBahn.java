import java.util.Objects;

public class SBahn extends Vehicle {
    public String model;

    public SBahn(Line line, String model) {
        super(line);
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("S-Bahn vrooms.");
    }

    @Override
    public void openDoors() {
        System.out.println("*beeeeeeeeep*. *gears moving*");
    }

    @Override
    public void closeDoors() {
        System.out.println("*bep* *bep* *bep* *bep* *bep* *bep*");
    }

    public SBahn[] splitTrains() {
        return new SBahn[]{new SBahn(super.getLINE(), model), new SBahn(super.getLINE(), model)};
    }

    public boolean connectTrains(SBahn otherSBahn) {
        if (otherSBahn == null) {
            System.out.println("To connect SBahns, there need to be exactly two.");
            return false;
        }
        if (this.getLINE() != otherSBahn.getLINE() || !Objects.equals(this.model, otherSBahn.model)) {
            System.out.println("SBahns need to be on the same line and have the same model to connect.");
            return false;
        }
        return true;
    }
}
