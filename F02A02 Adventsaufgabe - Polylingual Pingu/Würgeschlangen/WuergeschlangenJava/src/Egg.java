import java.util.Random;

/**
 * This class represents a (Snake) Egg with:
 * - information about the days until it hatches
 * - genus
 * - mother
 * - father
 */
public class Egg extends SnakeLike {
    static int nextNameIndex = 0;
    static String[] nextSnakeNames = {"Sssusan", "Zzzoe", "Sssteven", "Franc-hiss"};

    private int daysUntilHatch;
    private String genus;
    private Snake mother, father;

    /**
     * an Egg constructor requiring a genus and parents tuple
     *
     * @param genus
     * @param parents
     */
    public Egg(String genus, Snake[] parents) {
        this.genus = genus;

            /*
                In Java, there is no native `tuple` type like in Python (e.g. (Snake, Snake)).
                Using Pairs, similar functionality can be accomplished, but since we did not introduce Generics in Java yet,
                the sample solution here uses an array that is forced to hold 2 elements.
             */
        if (parents == null || parents.length != 2) {
            throw new IllegalArgumentException("'parents' must be exactly two snakes!");
        }
        this.mother = parents[0];
        this.father = parents[1];
    }

    /**
     * a method that slowly hatches the egg when incubated and always returns the "current entity",
     * i.e. either the yet-to-hatch Egg or a Snake once hatched
     * Since Java always requires the same return type, a SnakeLike is extended, which both Snake and Egg extend.
     *
     * @param currentDay
     * @return
     */
    public SnakeLike incubate(int currentDay) {
        Random random = new Random();
        int choice = random.nextInt(2);

        if (choice == 0) {
            this.daysUntilHatch--;
            System.out.println("🥚 The egg cracked a little. It will hatch soon!");
        }
        if (this.daysUntilHatch <= 0) {
            String snakeName = Egg.nextSnakeNames[Egg.nextNameIndex];
            Egg.nextNameIndex++;
            return new Snake(snakeName, this.genus, new Snake[]{this.mother, this.father}, currentDay);
        } else {
            return this;
        }
    }

    public int getDaysUntilHatch() {
        return daysUntilHatch;
    }

    public String getGenus() {
        return genus;
    }

    public Snake getMother() {
        return mother;
    }

    public Snake getFather() {
        return father;
    }
}