public class Cell {
    private CellState state;

    public Cell() {
        this.state = CellState.DEAD;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    @Override
    public String toString() {
        return switch (this.state) {
            case ABOUT_TO_BE_BORN -> "◻\uFE0F";
            case LIVING -> "⬜";
            case ABOUT_TO_DIE -> "◼\uFE0F";
            case DEAD -> "⬛";
        };
    }
}
