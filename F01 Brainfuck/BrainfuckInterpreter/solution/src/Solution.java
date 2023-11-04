import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // the initial tape - feel free to modify
        int[] tape = new int[0];
        boolean printAsChars = true;
        boolean showSteps = false;      // enable to see all steps executed

        // the brainfuck code to execute - feel free to modify
        // the template given produces Hello world!
        String brainfuckCode = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++."
                + "[-]>++++++++[<++++>-] <.>+++++++++++[<++++++++>-]<-.--------.+++.------."
                + "--------.[-]>++++++++[<++++>- ]<+.[-]++++++++++.";

        runBrainfuckSequence(tape, brainfuckCode, printAsChars, showSteps);
    }

    /**
     * Executes given Brainfuck code on a given tape.
     *
     * @param tape         the tape to start with
     * @param code         the Brainfuck code to execute
     * @param printAsChars whether console prints should give cell values as ints (false) or chars (true)
     */
    public static void runBrainfuckSequence(int[] tape, String code, boolean printAsChars, boolean showSteps) {
        code = code.replace(" ", "");   // get rid of all spaces

        if (tape == null) {           // initialize the tape if it is null
            tape = new int[0];
        }

        if (tape.length == 0) {     // if the given tape has no elements, add one cell
            tape = addPlaceToTape(tape, false);
        }

        int posInTape = 0;

        for (int posInCode = 0; posInCode < code.length(); posInCode++) {   // process all brainfuck commands
            switch (code.charAt(posInCode)) {
                case '<' -> {
                    if (posInTape == 0) {
                        tape = addPlaceToTape(tape, true);
                    } else {
                        posInTape--;
                    }
                }
                case '>' -> {
                    if (posInTape == tape.length - 1) {
                        tape = addPlaceToTape(tape, false);
                    }
                    posInTape++;
                }
                case '+' -> tape[posInTape]++;
                case '-' -> tape[posInTape]--;
                case '.' -> {
                    if (printAsChars) {
                        System.out.print((char) tape[posInTape]);
                    } else {
                        System.out.print(tape[posInTape]);
                    }
                }
                case ',' -> tape[posInTape] = readCharFromConsole();
                case '[' -> {
                    if (tape[posInTape] == 0) {
                        int bracketCount = 1;   // closing bracket: -1, opening bracket: +1
                        // start with 1 for first opening bracket
                        while (bracketCount != 0) {
                            posInCode++;
                            if (posInCode >= code.length()) {
                                System.out.println("Invalid brainfuck code, more opening than closing brackets");
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
                        posInCode--;
                        if (posInCode < 0) {
                            System.out.println("Invalid brainfuck code, more closing than opening brackets");
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
                    System.out.println("Invalid brainfuck code. Symbol '" + code.charAt(posInCode) + "' is not valid.");
                    return;
                }
            }

            if(showSteps) {
                prettyPrintCode(tape, code, posInCode, posInTape);
            }

        }
    }

    /**
     * Increases the array length by one, either to the left or right.
     *
     * @param oldTape the old tape that should be lengthened
     * @param inFront true, if the new cell should be added to the left, false if it should be added to the right
     * @return the new array
     */
    private static int[] addPlaceToTape(int[] oldTape, boolean inFront) {
        // if the cell is added to the left, the elements of the old array are simply moved one to the right
        // this is also the reason why positionInTape is not decreased in case the array is expanded to the left
        int[] newTape = new int[oldTape.length + 1];
        int offset = inFront ? 1 : 0;

        for (int i = 0; i < oldTape.length; i++) {
            newTape[i + offset] = oldTape[i];
        }
        return newTape;
    }

    private static void prettyPrintCode(int[] tape, String code, int posInCode, int posInTape) {
        String spacesBeforePointerSymbol = "\t\t\t       ";   // starting spaces to offset "tape: ["

        for (int i = 0; i < posInTape; i++) {
            spacesBeforePointerSymbol += "   ";         // three spaces for "i, "
            if(tape[i] >= 10){
                spacesBeforePointerSymbol += " ";
            }
        }

        System.out.print("Step " + posInCode);
        System.out.print(":\ttape: " + Arrays.toString(tape));
        System.out.println(",\tinstruction: " + code.charAt(posInCode));
        System.out.println(spacesBeforePointerSymbol + "^");
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
