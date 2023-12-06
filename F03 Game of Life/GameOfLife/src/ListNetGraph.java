import java.util.LinkedList;
import java.util.List;

/**
 * This is a NetGraph based on (pre-implemented) Lists.
 */
public class ListNetGraph extends NetGraph implements NeighbourKnowledge {
    private final List<List<Cell>> horizontalLine;

    public ListNetGraph(int w, int h) {
        super(w, h);
        horizontalLine = new LinkedList<>();
        initListNetGraph();
    }

    /**
     * Initializes the ListNetGraph with dead cells.
     */
    private void initListNetGraph() {
        for (int i = 0; i < width; i++) {
            List<Cell> newVerticalLine = new LinkedList<>();
            for (int j = 0; j < heigth; j++) {
                newVerticalLine.add(new Cell());
            }
            horizontalLine.add(newVerticalLine);
        }
    }

    public Cell getCellAt(int x, int y){
        if (x >= 0 && x < horizontalLine.size()
        && y >= 0 && y < horizontalLine.get(0).size()) {
            return horizontalLine.get(x).get(y);
        }
        return null;
    }

    public void setCellAt(int w, int h, Cell c) {
        if (w >= 0 && w < horizontalLine.size()
                && h >= 0 && h < horizontalLine.get(0).size()) {
            List<Cell> verticalLineAt = horizontalLine.get(w);
            verticalLineAt.set(h, c);
            horizontalLine.set(w, verticalLineAt);
        }
    }

    @Override
    public int getAliveNeighboursCount(int x, int y) {
        int aliveNeighbourCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int posX = x + i;
                int posY = y + j;
                //check valid position in list
                if (posX < 0 || posX >= horizontalLine.size() || posY < 0 || posY >= horizontalLine.get(0).size()) {
                    if (posX == x && posY == y) {
                        continue;
                    } else if (horizontalLine.get(posX).get(posY).getState() != CellState.DEAD) {
                        aliveNeighbourCount++;
                    }
                }
            }
        }
        return aliveNeighbourCount;
    }
}