public class Main {
    public static void main(String[] args) {
        Cell a = new Cell();
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell();

        a.setState(CellState.DEAD);
        b.setState(CellState.ABOUT_TO_BE_BORN);
        c.setState(CellState.LIVING);
        d.setState(CellState.ABOUT_TO_DIE);

        System.out.println("" + a + b + c + d);
    }
}