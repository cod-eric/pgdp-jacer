package oepnv;

public class UBahn extends Vehicle {
    public String model;

    public UBahn(LineNumber lineNumber, String model) {
        super(lineNumber);
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("U-Bahn vrooms.");
    }

    @Override
    public void openDoors() {
        System.out.println(super.getLINE() + ", bitte einsteigen.");
    }

    @Override
    public void closeDoors() {
        System.out.println("Bitte zurückbleiben. *beep*, *beep*, *beep*");
    }

    public void displayMuenchnerFenster() {
        System.out.println("Due to technical difficulties, we cannot show our infotainment program at the moment. We are sorry for any inconvenience caused.");
    }
}
