public abstract class NetGraph {
    //super für ListNetGraph, ArrayNetGraph
    protected int width;
    protected int heigth;

    public NetGraph(int w, int h) {
        this.width = w;
        this.heigth = h;
    }

    public int countOfCells() {
        return width * heigth;
    }

    public abstract int getCellAt(int w, int h);
    public abstract void setCellAt(int w, int h);
}
