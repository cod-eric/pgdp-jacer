public enum CellState {
    /**
     * Theoretically, Cells only need a LIVING and DEAD state. However, to make it more interesting,
     * cells that are about to be born or about to die will be displayed differently in the game.
     */
    ABOUT_TO_BE_BORN,
    LIVING,
    ABOUT_TO_DIE,
    DEAD
}
