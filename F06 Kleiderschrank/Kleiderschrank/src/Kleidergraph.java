import java.util.*;


public class Kleidergraph<T> {
    private Map<T, List<Edge<T>>> nodes;

    public Kleidergraph(){
        this.nodes = new HashMap<>();
    }

    /**
     * adds new Node
     * @param newNode to add
     */
    public void addNode(T newNode){
        //TODO
    }

    /**
     * removes Node
     * @param node Node to remove
     */
    public void removeNode(T node){
        //TODO
    }

    /**
     * adds new edge, updates weight if already existent
     * @param from start node
     * @param to end node
     * @param weight weight of the edge
     */
    public void addEdge(T from, T to, int weight){
        //TODO
    }

    /**
     * removes edge from the graph
     * @param from start node
     * @param to end node
     */
    public void removeEdge(T from, T to){
       //TODO
    }

    /**
     * returns all adjacent nodes
     * @param from node to get the adjacent ones
     * @return List of Nodes of type T
     */
    public List<T> getAdj(T from){
       //TODO
    }

    /**
     * Checks if there is an edge in the graph
     * @param from starting point
     * @param to end point
     * @return existense of edge
     */
    public boolean existsEdge(T from, T to){
        //TODO
    }

    /**
     * depth first Traversal of the graph starting with from
     * @param from
     */
    public void depthFirst(T from) {
//TODO
}



    /**
     * breadth first traversal
     * @param from node to start traversing from
     */
    public void breadthFirst(T from){
        //TODO
    }


    /**
     * Class for the edges
     * @param <T> Type of the Nodes
     */
    private static class Edge<T>{
        T endpoint;
        int weight;

        public Edge(T endpoint, int weight){
            this.endpoint = endpoint;
            this.weight = weight;
        }

    }

}
