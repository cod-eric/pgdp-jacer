public class Kleiderstange<T> {

    Kleiderhaken<T> erstes;

    /**
     * Method to add a new Element at the beginning of the Linked List
     * @param newEl     Element to be added
     */
    public void add(T newEl){
        //TODO
    }

    /**
     * Recursive Method to remove nth element
     * @param n     index to remove
     * @return      value of removed Element
     */
    public T removeNthRec(int n){
       //TODO
        return null;
    }

    /**
     * Non-recursive Method to remove nth element
     * @param n     index to remove
     * @return      value of removed Element
     */
    public T removeNthIt(int n){
        //TODO
        return null;
    }

    /**
     * Recursive Method to filter all elements of Type Socke
     */
    public void filterSocksRec(){
        //TODO
    }

    /**
     * Recursive Method to insert element at given index
     * @param n     index to insert
     * @param element   element to insert
     */
    public void insertAtRec(int n, T element){
        //TODO

    }
    /**
     * Non-Recursive Method to insert element at given index
     * @param n     index to insert
     * @param element   element to insert
     */
    public void insertAtIt(int n, T element){
       //TODO

    }

    /**
     * Non-Recursive Method to filter all elements of Type Socke
     */
    public void filterSocksIt(){
       //TODO
    }


    /**
     * Recursive contains method for List
     * @param element element to check for
     * @return  contains element
     */
    public boolean containsRec(T element){
        //TODO
        return false;
    }

    /**
     * Non-Recursive contains method for List
     * @param element element to check for
     * @return  contains element
     */
    public boolean containsIt(T element){
        //TODO
        return false;
    }


    /**
     * TODO implement filterSingleSocks
     */


    /**
     * Class for the elements of the Kleiderstange
     * @param <T> value saved in each Element
     */
    private static class Kleiderhaken<T>{
    //TODO implement Kleiderhaken

    }

    /**
     * Example class Socke to add to the Kleiderstange
     * each object has a counterpart of the same class
     */
    public static class Socke {

        private Socke counterpart;

        public Socke getCounterpart() {
            return counterpart;
        }

        public void setCounterpart(Socke counterpart) {
            this.counterpart = counterpart;
        }
    }

}
