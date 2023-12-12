package oepnv;

public abstract class Human {
    protected String name;
    protected int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void talk() {
        System.out.println(name + " says: blablabla");
    }

    public void sleep(int duration) {
        System.out.println(name + " sleeps for " + duration + " hours.");
    }
}
