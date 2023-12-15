package oepnv;

public abstract class OEPNVEmployee extends Human {
    private int salary;

    public OEPNVEmployee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public abstract void strike();
}
