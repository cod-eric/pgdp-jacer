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
        if(!nodes.containsKey(newNode))
            nodes.put(newNode, new ArrayList<>());
    }

    /**
     * removes Node
     * @param node Node to remove
     */
    public void removeNode(T node){
        if(nodes.containsKey(node))
            nodes.remove(node);
    }

    /**
     * adds new edge, updates weight if already existent
     * @param from start node
     * @param to end node
     * @param weight weight of the edge
     */
    public void addEdge(T from, T to, int weight){
        if(!nodes.containsKey(from)){
            this.addNode(from);
        }

        List<Edge<T>> edges = nodes.get(from);
        for(Edge<T> edge : edges){
            if(to.equals(edge.endpoint)) {
                edge.weight = weight;
                return;
            }

        }

        edges.add(new Edge<>(to,weight));
    }

    /**
     * removes edge from the graph
     * @param from start node
     * @param to end node
     */
    public void removeEdge(T from, T to){
        if(nodes.containsKey(from)){
            List<Edge<T>> edges = nodes.get(from);

            for(Edge<T> edge :edges){
                if(to.equals(edge.endpoint)){
                    edges.remove(edges);
                }
            }

        }
    }

    /**
     * returns all adjacent nodes
     * @param from node to get the adjacent ones
     * @return List of Nodes of type T
     */
    public List<T> getAdj(T from){
        List<T> returnNodes = new ArrayList<>();
        for(Edge<T> edge : nodes.get(from)){
            returnNodes.add(edge.endpoint);
        }
        return returnNodes;
    }

    /**
     * Checks if there is an edge in the graph
     * @param from starting point
     * @param to end point
     * @return existense of edge
     */
    public boolean existsEdge(T from, T to){
        if(!nodes.containsKey(from)) return false;

        List<Edge<T>> edges = nodes.get(from);
        for(Edge<T> edge : edges){
            if(to.equals((edge.endpoint)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * depth first Traversal of the graph starting with from
     * @param from
     */
    public void depthFirst(T from) {
        depthFirstRec(from, new HashSet<>(),0);
    }

    /**
     * Recursive approach for a depth first traversal
     * @param from node to continue the traversal from
     * @param visited Set of nodes that already have been visited
     * @param dist distance between the start node and current one
     */
    private void depthFirstRec(T from, Set<T> visited, int dist){
        visited.add(from);
        System.out.print(from + ":" + dist + " ");

        for(Edge<T> edge: nodes.get(from)){
            T nextNode = edge.endpoint;
            if(!visited.contains(nextNode)){
                depthFirstRec(nextNode, visited, dist+edge.weight);
            }

        }
    }

    /**
     * breadth first traversal
     * @param from node to start traversing from
     */
    public void breadthFirst(T from){
        Queue<T> nextNode = new PriorityQueue<>();
        nextNode.add(from);

        Map<T,Integer> visited = new HashMap<>();
        visited.put(from,0);

        while(!nextNode.isEmpty()){
            T current = nextNode.poll();
            int currentDist = visited.get(current);
            System.out.print(current+":"+currentDist+" ");

            for(Edge<T> edge : nodes.get(current)){
                T value = edge.endpoint;

                if(!visited.containsKey(value)){
                    nextNode.add(value);
                    visited.put(value,currentDist+edge.weight);
                }
            }
        }

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
