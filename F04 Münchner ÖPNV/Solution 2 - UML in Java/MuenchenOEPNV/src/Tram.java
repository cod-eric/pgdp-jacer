public class Tram extends Vehicle {
    public Tram(Line line) {
        super(line);
    }

    @Override
    public void move() {
        System.out.println("Tram vrooms.");
    }

    @Override
    public void openDoors() {
        System.out.println("*pshhhhh*");
    }

    @Override
    public void closeDoors() {
        System.out.println("*beep* *beep*");
    }

    public void ringBell() {
        System.out.println("*ring* *ring*");
    }
}
