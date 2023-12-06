import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            ##################
            # Code procedure #
            ##################
        */

        /*
            set up the terrarium

            This is not the best way to create the python equivalent of a dictionary.
            Would be better to use a HashMap, but this also uses Generics, so I won't show it here.
            Look into it if you are interested. :)

            We use two variables, snakes and eggs, to store the index we will access
         */
        SnakeLike[][] terrarium = {new SnakeLike[]{}, new SnakeLike[]{}};
        int snakes = 0, eggs = 1;

        // two initial snakes - Adam and Eve
        Snake adam = new Snake("Adam", "Zwergpython", new Snake[]{null, null}, 0);
        Snake eve = new Snake("Eve", "Wasserpython", new Snake[]{null, null}, 0);

        terrarium[snakes] = enlargeSnakeLikeArray(terrarium[snakes]);
        System.out.println(terrarium[snakes].length);
        terrarium[snakes][terrarium[snakes].length - 1] = adam;

        terrarium[snakes] = enlargeSnakeLikeArray(terrarium[snakes]);
        terrarium[snakes][terrarium[snakes].length - 1] = eve;

        System.out.println(adam.getName() + " and " + eve.getName() + " moved into the terrarium.");


        // let Adam and Eve lay 3 eggs
        for (int i = 0; i < 3; i++) {
            terrarium[eggs] = enlargeSnakeLikeArray(terrarium[eggs]);
            terrarium[eggs][terrarium[eggs].length - 1] = adam.breed(eve);
            System.out.println("🪺 An egg was laid!");
        }

        // now incubate the eggs until all the baby snakes hatched
        System.out.println("The eggs will now be incubated");
        int day = 0;
        while (terrarium[eggs].length != 0) {
            System.out.println("☀️ A new day " + day + " begins");
            for (int i = 0; i < terrarium[eggs].length; i++) {
                Egg eggInTerrarium = (Egg) terrarium[eggs][i];
                if (terrarium[eggs][i].getClass().equals(Egg.class)) {
                    System.out.println("Incubating egg in the hatchery station at position " + i
                            + "  - needs " + eggInTerrarium.getDaysUntilHatch() + " more days to hatch");
                } else {
                    throw new ClassCastException("The SnakeLike in terrarium[eggs] at position " + i + " is not an Egg.");
                }

                SnakeLike eggOrSnake = eggInTerrarium.incubate(day);
                if (eggOrSnake.getClass().equals(Snake.class)) {
                    Snake snake = (Snake) eggOrSnake;
                    System.out.println("Placing the new snake into the terrarium");
                    terrarium[snakes] = enlargeSnakeLikeArray(terrarium[snakes]);
                    terrarium[snakes][terrarium[snakes].length - 1] = snake;
                    snake.slither();
                }
            }

            System.out.println("🧹 Cleaning up the eggshells of hatched snakes");
            int eggsLeft = 0;
            for (SnakeLike snakeLikeEgg : terrarium[eggs]) {
                Egg egg = (Egg) snakeLikeEgg;
                if (egg.getDaysUntilHatch() > 0) {
                    eggsLeft++;
                }
            }
            SnakeLike[] newTerrariumEggs = new SnakeLike[eggsLeft];
            int posInNewTerrariumEggs = 0;
            for (SnakeLike snakeLikeEgg : terrarium[eggs]) {
                Egg egg = (Egg) snakeLikeEgg;
                if (egg.getDaysUntilHatch() > 0) {
                    newTerrariumEggs[posInNewTerrariumEggs] = snakeLikeEgg;
                    posInNewTerrariumEggs++;
                }
            }
            terrarium[eggs] = newTerrariumEggs;

            day++;
        }

        // let's simulate the snakes living in the terrarium until the visitor leaves
        System.out.println("The terrarium is now opened to visitors");
        boolean visitorStillWatching = true;
        Random random = new Random();
        while (visitorStillWatching) {
            for (int i = 0; i < random.nextInt(1, 4); i++) {
                int snakeTakingActionPosition = random.nextInt(terrarium[snakes].length);
                Snake snakeTakingAction = (Snake)terrarium[snakes][snakeTakingActionPosition];
                if (random.nextInt(2) == 0) {
                    snakeTakingAction.hiss();
                } else {
                    snakeTakingAction.slither();
                }
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("🤵 The museum curator asks: Do you want to keep watching the [s]nakes or [l]eave?");
                String userInput = scanner.nextLine();
                if (userInput.equals("l")) {
                    System.out.println("The museum is now closed for the day.");
                    return;
                } else if (userInput.equals("s")) {
                    break;
                } else {
                    System.out.println("The museum curator did not understand what you said.");
                }
            }
        }
    }

    private static SnakeLike[] enlargeSnakeLikeArray(SnakeLike[] currentArray) {
        // you might now see how complicated it is to append a new item to an array in Java...
        SnakeLike[] newSnakes = new SnakeLike[currentArray.length + 1];
        System.arraycopy(currentArray, 0, newSnakes, 0, currentArray.length);
        return newSnakes;
    }
}
