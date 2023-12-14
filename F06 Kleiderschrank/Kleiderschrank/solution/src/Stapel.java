public class Stapel <T> {

    Stapelelement<T> first;

    /**
     * pushes element on top of the stack
     * @param element element to push
     */
    public void push(T element){
        Stapelelement<T> newElement = new Stapelelement<>(element);
        if(first==null){
            first = newElement;
        }
        else {
            newElement.next = first;
            first = newElement;
        }
    }

    /**
     * removes topmost element of the stack
     * @return value of the topmost elment, null for empty stack
     */
    public T pop(){
        if(first == null){
            return null;
        }
        else{
            T value = first.value;
            first = first.next;
            return value;
        }
    }

    /**
     * reverses the given Stack
     * @param stapel Stack to revers
     * @return reversed Stack
     * @param <S> type of Stackelements
     */
    public static <S> Stapel<S> reverse(Stapel<S> stapel){
        Stapel<S> reversed = new Stapel<>();
        S element = stapel.pop();

        while(element !=null){
            reversed.push(element);
            element = stapel.pop();
        }
        return reversed;
    }



    private static class Stapelelement<T>{
        private T value;
        private Stapelelement<T> next;

        public Stapelelement(T value){
            this.value = value;
        }

    }
}
