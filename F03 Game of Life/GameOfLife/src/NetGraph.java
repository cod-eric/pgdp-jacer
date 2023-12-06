public abstract class NetGraph {
    //super für ListNetGraph, ArrayNetGraph
    protected int width;
    protected int heigth;

    public NetGraph(int w, int h) {
        this.width = w;
        this.heigth = h;
    }

    /**
     *
     * @return count of cells this NetGraph stores
     */
    public int countOfCells() {
        return width * heigth;
    }

    /**
     * Returns the cell at the given coordinates.
     * @param x x position
     * @param y y position
     * @return  the Cell at the position
     */
    public abstract Cell getCellAt(int x, int y);

    /**
     * Sets the cell at the given coordinates to the given cell.
     * @param x x position
     * @param y y position
     * @param c the new Cell
     */
    public abstract void setCellAt(int x, int y, Cell c);
}
