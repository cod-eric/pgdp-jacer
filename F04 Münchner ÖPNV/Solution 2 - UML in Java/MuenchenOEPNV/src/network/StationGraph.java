package network;

import oepnv.Station;

import java.lang.reflect.Array;

public class StationGraph implements Graph<Station> {
    Integer[][] graph;
    Node[] keySet;

    public StationGraph(int numOfNodes) {
        this.graph = new Integer[numOfNodes][numOfNodes];
        this.keySet = new Node[numOfNodes];
    }

    @Override
    public void addNode(Node<Station> n) {
        enlargeGraphByOne();
        enlargeKeySetByOne();
        keySet[keySet.length - 1] = n;
    }

    private int getIndexOf(Node<Station> n) {
        for (int i = 0; i < keySet.length; i++) {
            if (keySet[i].id == n.id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeNode(Node<Station> n) {
        int idx = getIndexOf(n);
        if (idx < 0 || idx >= graph.length) {
            return;
        }
        shrinkGraph(getIndexOf(n));
    }

    @Override
    public void addEdge(Node<Station> from, Node<Station> to, int weight) {
        int idxFrom = getIndexOf(from);
        int idxTo = getIndexOf(to);
        if (idxFrom < 0 || idxFrom >= graph.length || idxTo < 0 || idxTo >= graph.length) {
            return;
        }
        graph[idxFrom][idxTo] = weight;
    }

    @Override
    public void removeEdge(Node from, Node to) {

    }

    @Override
    public int getWeight(Node from, Node to) {
        return 0;
    }

    /*
        given helper methods
     */

    /**
     * Enlarges graph by one.
     */
    private void enlargeGraphByOne() {
        Integer[][] newGraph = new Integer[graph.length + 1][graph.length + 1];
        for (int i = 0; i < graph.length; i++) {
            newGraph[i] = enlargeArrayByOne(graph[i]);
        }
        newGraph[newGraph.length - 1] = new Integer[newGraph.length];

        graph = newGraph;
    }

    /**
     * Enlarges keyset by one.
     */
    private void enlargeKeySetByOne() {
        Node[] newKeySet = new Node[keySet.length + 1];
        newKeySet = enlargeArrayByOne(keySet);

        keySet = newKeySet;
    }

    /**
     * Enlarges a given array by one.
     *
     * @param array current array
     * @param <T>   type of values in array (e.g. String, int[], double[][], ...)
     * @return enlarged array
     */
    private static <T> T[] enlargeArrayByOne(T[] array) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    /**
     * Shrinks graph by one
     *
     * @param skipIndex the index to skip
     */
    private void shrinkGraph(int skipIndex) {
        Integer[][] newGraph = new Integer[graph.length - 1][graph.length - 1];
        int skipAdd = 0;
        for (int j = 0; j < graph.length - 1; j++) {
            if (j == skipIndex) {
                skipAdd = 1;
            }
            newGraph[j] = shrinkArrayByOne(graph[j + skipAdd], skipIndex);
        }

        graph = newGraph;
    }

    /**
     * shrinks keyset by one
     *
     * @param skipIndex the index to skip
     */
    private void shrinkKeyset(int skipIndex) {
        keySet = shrinkArrayByOne(keySet, skipIndex);
    }

    /**
     * Shrinks a given array by one, skipping the given index.
     *
     * @param array     current array
     * @param skipIndex the index to skip
     * @param <T>       type of values in array (e.g. String, int[], double[][], ...)
     * @return shrunken array
     */
    private static <T> T[] shrinkArrayByOne(T[] array, int skipIndex) {
        if (skipIndex >= array.length || skipIndex < 0) {
            throw new IllegalArgumentException("skipIndex must be in bounds of array.");
        }
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        System.arraycopy(array, 0, newArray, 0, skipIndex);
        System.arraycopy(array, skipIndex + 1, newArray, skipIndex, array.length - skipIndex);
        return newArray;
    }
}
