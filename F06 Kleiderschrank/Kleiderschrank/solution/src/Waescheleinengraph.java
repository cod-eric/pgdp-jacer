import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Waescheleinengraph<T> {
    private Map<T, List<T>> vertices;

    public Waescheleinengraph(){
        this.vertices = new HashMap<>();
    }

    /**
     * adds vertex to the map
     * @param newVertex new key
     */
    public void addVertex(T newVertex){
        if(!vertices.containsKey(newVertex))
            vertices.put(newVertex, new ArrayList<>());
    }

    /**
     * removes vertex
     * @param vertex key to remove
     */
    public void removeVertex(T vertex){
        if(vertices.containsKey(vertex))
            vertices.remove(vertex);
    }

    /**
     * adds an edge
     * @param from node of the edges starting point
     * @param to node of the edges end point
     */
    public void addEdge(T from, T to){
        if(!vertices.containsKey(from)){
            this.addVertex(from);
        }

        List<T> edges = vertices.get(from);
        if(!edges.contains(to)) edges.add(to);
    }

    /**
     * removes edge
     * @param from starting point of edge
     * @param to end point of edge
     */
    public void removeEdge(T from, T to){
        if(vertices.containsKey(from)){
            List<T> edges = vertices.get(from);
            if(edges.contains(to)){
                vertices.remove(to);
            }

        }
    }

    /**
     * checks if edge is present
     * @param from starting point of edge
     * @param to edges end point
     * @return if edge is contained
     */
    public boolean existsEdge(T from, T to){
        if(!vertices.containsKey(from)) return false;
        else return vertices.get(from).contains(to);
    }



}
