public class Kleiderstapel<T> {
    private Stapel<T> first;
    private Stapel<T> second;

    public Kleiderstapel(){
        first = new Stapel<>();
        second = new Stapel<>();
    }

    /**
     * pushes an element on the first Stack
     * @param element element to add
     */
    public void push(T element){
        //TODO
    }

    /**
     * removes the topmost element from the first Stack
     * @return topmost element of the first stack if present, else null
     */
    public T pop(){
        //TODO
        return null;
    }

    /**
     * removes first occurence of element
     * @param element element to remove
     */
    public void remove(T element){
        //TODO
    }

    /**
     * removes all occurences
     * @param element element to remove
     */
    public void removeAll(T element){
        //TODO
    }

    /**
     * merges the two stacks by alternating the topmost elements
     */
    public void mergeStacks(){
        //TODO

    }



}


