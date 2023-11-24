import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cell[][] playfield = {
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        };

        int round = 0, currentPlayer = 0;
        boolean newRound = true;

        while (true) {
            if (newRound) {
                round++;
                currentPlayer = round % 2;
                System.out.println("Round " + round);

                prettyPrintArray(playfield);
            } else {
                newRound = true;
            }

            System.out.println("Which cell do you want to play? (Use one digit (0-8) to determine cell or 'q' to quit.)");
            String cellUserWantsToPlay = readInput();

            if (cellUserWantsToPlay != null) {
                if (cellUserWantsToPlay.equals("q")) {
                    break;
                }
                int cellUserWantsToPlayInt = Integer.parseInt(cellUserWantsToPlay);
                if (cellUserWantsToPlayInt < 0 || cellUserWantsToPlayInt > 8) {
                    System.out.println("Please enter a valid field.");
                    newRound = false;
                    continue;
                }

                int row = cellUserWantsToPlayInt / 3;
                int col = cellUserWantsToPlayInt % 3;

                if (playfield[row][col] != Cell.EMPTY) {
                    System.out.println("Cell is not empty. Please enter a valid cell position.");
                    newRound = false;
                    continue;
                }

                if (currentPlayer == 0) {
                    playfield[row][col] = Cell.O;
                } else {
                    playfield[row][col] = Cell.X;
                }

                Cell winner = checkIfWon(playfield);
                if (winner != Cell.EMPTY) {
                    System.out.println("Player " + winner + " won!");
                    break;
                }
            }
        }
    }

    private static Cell checkIfWon(Cell[][] field) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]){
                return field[i][0];     // returns the player who won
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i]){
                return field[0][i];     // returns the player who won
            }
        }

        // check diagonal top left to bottom right
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            return field[0][0];
        }

        // check diagonal bottom left to top right
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            return field[0][2];
        }

        return Cell.EMPTY;   // signals that no player won yet
    }


    private static void prettyPrintArray(Cell[][] field) {
        StringBuilder line = new StringBuilder("\n");
        for (Cell[] row : field) {
            for (Cell cell : row) {
                if (cell == Cell.X) {
                    line.append("X ");
                } else if (cell == Cell.O) {
                    line.append("O ");
                } else {
                    line.append("_ ");
                }
            }
            line.append("\n");
        }
        System.out.print(line);
    }

    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}