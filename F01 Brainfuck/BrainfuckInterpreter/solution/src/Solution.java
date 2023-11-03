import java.util.Arrays;
import java.util.Scanner;

public class Solution {

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
     * @param tape         the tape to start with
     * @param code         the Brainfuck code to execute
     * @param printAsChars whether console prints should give cell values as ints (false) or chars (true)
     */
    public static void runBrainfuckSequence(int[] tape, String code, boolean printAsChars) {
        code = code.replace(" ", "");   // get rid of all spaces
        int positionInTape = 0;

        // in case the given tape has no elements, one cell is added (such that the head points to something at all times)
        if (tape.length == 0) {
            tape = addPlaceToTape(tape, false);
        }

        for (int posInCode = 0; posInCode < code.length(); posInCode++) {
            switch (code.charAt(posInCode)) {
                case '<' -> {
                    if (positionInTape == 0) {
                        tape = addPlaceToTape(tape, true);
                    } else {
                        positionInTape--;
                    }
                }
                case '>' -> {
                    if (positionInTape == tape.length - 1) {
                        tape = addPlaceToTape(tape, false);
                    }
                    positionInTape++;
                }
                case '+' -> tape[positionInTape]++;
                case '-' -> tape[positionInTape]--;
                case '.' -> {
                    if (printAsChars) {
                        System.out.print((char) tape[positionInTape]);
                    } else {
                        System.out.print(tape[positionInTape]);
                    }
                }
                case ',' -> tape[positionInTape] = readCharFromConsole();
                case '[' -> {
                    if (tape[positionInTape] == 0) {
                        int bracketCount = 1;   // closing bracket: -1, opening bracket: +1
                        // start with 1 for first opening bracket
                        while (bracketCount != 0) {
                            posInCode++;
                            if (posInCode >= code.length()) {
                                System.out.println("invalid brainfuck code, more opening than closing brackets");
                                return;
                            } else if (code.charAt(posInCode) == '[') {
                                bracketCount++;
                            } else if (code.charAt(posInCode) == ']') {
                                bracketCount--;
                            }
                        }
                    }
                }
                case ']' -> {
                    int bracketCount = -1;  // closing bracket: -1, opening bracket: +1
                    // start with -1 for first closing bracket
                    while (bracketCount != 0) {
                        char charInCode = code.charAt(posInCode);
                        posInCode--;
                        if (posInCode < 0) {
                            System.out.println("invalid brainfuck code, more closing than opening brackets");
                            return;
                        } else if (code.charAt(posInCode) == '[') {
                            bracketCount++;
                        } else if (code.charAt(posInCode) == ']') {
                            bracketCount--;
                        }
                    }
                    posInCode--;
                }
                default -> {
                    System.out.println(
                            "invalid brainfuck code. symbol '"
                                    + code.charAt(posInCode)
                                    + "' is not valid."
                    );
                    return;
                }
            }
            //pretty print code vvv
            System.out.println(
                    "tape: " + Arrays.toString(tape)
                            + ", instruction: " + code.charAt(posInCode)
                            + ", position in code: " + posInCode
            );
            String spacesBeforePointerSymbol = "       ";   // starting spaces to offset "tape: ["
            for (int i = 0; i < positionInTape; i++) {
                spacesBeforePointerSymbol += "   ";         // three spaces for "i, "
            }
            System.out.println(spacesBeforePointerSymbol + "^");
        }
        System.out.println();
    }

    /**
     * Increases the array length by one, either to the left or right.
     *
     * @param oldTape the old tape that should be lengthened
     * @param inFront true, if the new cell should be added to the left, false if it should be added to the right
     * @return the new array
     */
    private static int[] addPlaceToTape(int[] oldTape, boolean inFront) {
        int[] newTape = new int[oldTape.length + 1];
        // if the cell is added to the left, the elements of the old array are simply moved one to the right
        // this is also the reason why positionInTape is not decreased in case the array is expanded to the left
        int offset = inFront ? 1 : 0;
        for (int i = 0; i < oldTape.length; i++) {
            newTape[i + offset] = oldTape[i];
        }
        return newTape;
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