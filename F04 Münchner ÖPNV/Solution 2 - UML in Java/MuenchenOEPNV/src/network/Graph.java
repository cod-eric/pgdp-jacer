package network;

public interface Graph<V> {
    void addNode(Node<V> n);
    void removeNode(Node<V> n);
    void addEdge(Node<V> from, Node<V> to, int weight);
    void removeEdge(Node<V> from, Node<V> to);
    int getWeight(Node<V> from, Node<V> to);

    public static class Node<V> {
        V id;

        public Node (V v) {
            this.id = v;
        }

        public V getValue() {
            return id;
        }
    }
}
