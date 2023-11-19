import java.util.Arrays;
import java.util.Random;

/**
 * This class represents a Snake with:
 * - name
 * - genus
 * - mother
 * - father
 * - date born
 */
public class Snake extends SnakeLike {
    static String[] snakeGenera = {"Zwergpython", "Baumpython", "Schwarzkopfpython", "Wasserpython", "Raupenpython", "Netzpython"};
    private String name, genus;
    private Snake mother, father;
    private int birthday;

    /**
     * a Snake constructor which requires a name, genus, parents tuple and birthday
     *
     * @param name
     * @param genus
     * @param parents
     * @param birthday
     */
    public Snake(String name, String genus, Snake[] parents, int birthday) {
        this.name = name;

        if (!Arrays.asList(snakeGenera).contains(genus)) {
            System.out.println("This looks like a weird mutation...");
            this.genus = snakeGenera[0];
        } else {
            this.genus = genus;
        }

            /*
                In Java, there is no native `tuple` type like in Python (e.g. (Snake, Snake)).
                Using Pairs, similar functionality can be accomplished, but since we did not introduce Generics in Java yet,
                the sample solution here uses an array that is forced to hold 2 elements.

                Note that we *do not* check whether the two snakes are null - just like in the Python implementation,
                the "original" snakes Adam and Eve do not have parent snakes.
             */
        if (parents == null || parents.length != 2) {
            throw new IllegalArgumentException("'parents' must be exactly two snakes!");
        }
        this.mother = parents[0];
        this.father = parents[1];

        this.birthday = birthday;
    }

    public void hiss() {
        System.out.println("💤 " + this.name + " hisses!");
    }

    public void slither() {
        System.out.println("🐍 " + this.name + " slithers!");
    }

    public Egg breed(Snake otherSnake) {
        if (otherSnake == null) {
            throw new IllegalArgumentException("'otherSnake' may not be null to breed!");
        }
        Random random = new Random();
        int randomChosenName = random.nextInt(snakeGenera.length);
        return new Egg(snakeGenera[randomChosenName], new Snake[]{this, otherSnake});
    }

    public String getName() {
        return name;
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

    public int getBirthday() {
        return birthday;
    }
}