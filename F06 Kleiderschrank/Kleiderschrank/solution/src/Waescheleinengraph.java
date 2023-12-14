import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Waescheleinengraph<T> {
    private Map<T, List<T>> nodes;

    public Waescheleinengraph(){
        this.nodes = new HashMap<>();
    }

    public void addNode(T newNode){
        if(!nodes.containsKey(newNode))
            nodes.put(newNode, new ArrayList<>());
    }

    public void addEdge(T from, T to){
        if(!nodes.containsKey(from)){
            this.addNode(from);
        }

        List<T> edges = nodes.get(from);
        if(!edges.contains(to)) edges.add(to);
    }

    public boolean existsEdge(T from, T to){
        if(!nodes.containsKey(from)) return false;
        else return nodes.get(from).contains(to);
    }

    public boolean kreisfrei(){
        return false;
    }

}
