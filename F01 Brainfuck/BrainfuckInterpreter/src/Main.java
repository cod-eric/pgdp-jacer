import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // the starting tape - feel free to modify
        int[] tape = new int[0];

        // the brainfuck code to execute - feel free to modify
        // the template given produces Hello world!
        String brainfuckCode = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++."
                + "[-]>++++++++[<++++>-] <.>+++++++++++[<++++++++>-]<-.--------.+++.------."
                + "--------.[-]>++++++++[<++++>- ]<+.[-]++++++++++.";

        runBrainfuckSequence(tape, brainfuckCode, true);
    }

    /**
     * Executes given Brainfuck code on a given tape.
     *
     * @param tape          the tape to start with
     * @param code          the Brainfuck code to execute
     * @param printAsChars  whether console prints should give cell values as ints (false) or chars (true)
     */
    public static void runBrainfuckSequence(int[] tape, String code, boolean printAsChars) {
        //TODO
    }

    /**
     * Increases the array length by one, either to the left or right.
     *
     * @param oldTape   the old tape that should be lengthened
     * @param inFront   true, if the new cell should be added to the left, false if it should be added to the right
     * @return          the new array
     */
    private static int[] addPlaceToTape(int[] oldTape, boolean inFront) {
        //TODO
        return null;
    }

    /**
     * Reads the next char from the console.
     *
     * @return read char
     */
    private static char readCharFromConsole() {
        Scanner s = new Scanner(System.in);
        return s.next().charAt(0);
    }
}