public class Stapel<T> {

    StapelElement<T> first;

    /**
     * pushes element on top of the stack
     *
     * @param element element to push
     */
    public void push(T element) {
        //TODO
    }

    /**
     * removes topmost element of the stack
     *
     * @return value of the topmost elment, null for empty stack
     */
    public T pop() {
        //TODO
        return null;
    }

    /**
     * reverses the given Stack
     *
     * @param stapel Stack to revers
     * @param <S>    type of Stackelements
     * @return reversed Stack
     */
    public static <S> Stapel<S> reverse(Stapel<S> stapel) {
        //TODO
        return null;
    }


    private static class StapelElement<T> {
        //TODO implement class StapelElement
    }
}
