/**
 * Our main class
 */
public class Main {

    // Some young penguins are having fun with their new Java skills.
    // However, they are still a little inexperienced, and thus some errors sneaked into their programs.
    // Can you find them?
    // Todo: find all [3] errors

    /**
     * Our main method that is executed at the program start
     *
     * @param args this is some Java stuff you can ignore for now
     */
    public static void main(String[] args) {
        // Create 2 new penguins
        Pingu p1 = new Pingu("Eric", "Trout", 200000);
        Pingu p2 = new Pingu("Eric", "Trout", 200000);
        System.out.println("Hooray, they are the same: " + (p1 == p2));

        // Now, let's create a veeeery old penguin
        long oldAge = 20000000000000L;
        Pingu p3 = new Pingu("Jonas", "Salmon", oldAge);
        long jonasAge = (long) p3.getMillisLivedAlready();
        System.out.println("Jonas is this old: " + oldAge + " ==? " + jonasAge);


        // What fish species could this aged penguin prefer for dinner?
        System.out.println(p3.getFavouriteFishSpecies());

    }

}
