package oepnv;

import java.util.Objects;

public class SBahn extends Vehicle {
    public String model;

    public SBahn(LineNumber lineNumber, String model) {
        super(lineNumber);
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
        return new SBahn[]{new SBahn(super.lineNumber, model), new SBahn(super.lineNumber, model)};
    }

    public boolean connectTrains(SBahn otherSBahn) {
        if (otherSBahn == null) {
            System.out.println("To connect SBahns, there need to be exactly two.");
            return false;
        }
        if (this.lineNumber != otherSBahn.lineNumber || !Objects.equals(this.model, otherSBahn.model)) {
            System.out.println("SBahns need to be on the same line and have the same model to connect.");
            return false;
        }
        return true;
    }
}
