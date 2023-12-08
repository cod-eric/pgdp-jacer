public class ArrayNetGraph extends NetGraph implements NeighbourKnowledge {
    private Cell[][] arrayGraph;

    public ArrayNetGraph(int w, int h) {
        super(w, h);
        arrayGraph = new Cell[w][h];
    }

    private void initArrayNetGraph() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                arrayGraph[i][j] = new Cell();
            }
        }
    }

    @Override
    public int getAliveNeighboursCount(int x, int y) {
        int aliveNeighbourCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int posX = x + i;
                int posY = y + j;
                //check valid position in array
                if (posX < 0 || posX >= arrayGraph.length || posY < 0 || posY >= arrayGraph[0].length) {
                    if (posX == x && posY == y) {
                        continue;
                    } else if (arrayGraph[posX][posY].getState() != CellState.DEAD) {
                        aliveNeighbourCount++;
                    }
                }
            }
        }
        return aliveNeighbourCount;
    }

    @Override
    public Cell getCellAt(int x, int y) {
        if (x >= 0 && x < arrayGraph.length
                && y >= 0 && y < arrayGraph[0].length) {
            return arrayGraph[x][y];
        }
        return null;
    }

    @Override
    public void setCellAt(int x, int y, Cell c) {
        if (x >= 0 && x < arrayGraph.length
                && y >= 0 && y < arrayGraph[0].length) {
            arrayGraph[x][y] = c;
        }
    }
}
