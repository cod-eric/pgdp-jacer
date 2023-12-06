public interface NeighbourKnowledge {
    /**
     * Counts the amount of alive neighbours in the surrounding 3x3 area of a cell at given coordinates
     * @param x x position
     * @param y y position
     * @return  amount of alive neighbours
     */
    public int getAliveNeighboursCount(int x, int y);
}
