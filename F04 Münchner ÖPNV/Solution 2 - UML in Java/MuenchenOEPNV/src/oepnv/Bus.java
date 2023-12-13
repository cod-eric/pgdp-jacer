package oepnv;

public class Bus extends Vehicle {
    public Bus(LineNumber lineNumber) {
        super(lineNumber);
    }

    @Override
    public void move() {
        System.out.println("Bus vrooms.");
    }

    @Override
    public void openDoors() {
        System.out.println("*pfshhh*");
    }

    @Override
    public void closeDoors() {
        System.out.println("*pshhhf*");
    }

    public void lowerRightSide() {
        System.out.println("Bus lowers right side for passengers to enter.");
    }
}
