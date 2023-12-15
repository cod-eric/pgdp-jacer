public class Kleiderstapel<T> {
    private Stapel<T> first;
    private Stapel<T> second;

    public Kleiderstapel() {
        first = new Stapel<>();
        second = new Stapel<>();
    }

    /**
     * pushes an element on the first Stack
     *
     * @param element element to add
     */
    public void push(T element) {
        first.push(element);
    }

    /**
     * removes the topmost element from the first Stack
     *
     * @return topmost element of the first stack if present, else null
     */
    public T pop() {
        return first.pop();
    }

    /**
     * removes first occurence of element
     *
     * @param element element to remove
     */
    public void remove(T element) {
        T top = first.pop();
        while (top != null) {
            if (top.equals(element)) {
                break;
            } else {
                second.push(top);
                top = first.pop();
            }
        }
    }

    /**
     * removes all occurences
     *
     * @param element element to remove
     */
    public void removeAll(T element) {
        T top = first.pop();
        while (top != null) {
            if (!top.equals(element)) {
                second.push(top);
            }
            top = first.pop();
        }
    }

    /**
     * merges the two stacks by alternating the topmost elements
     */
    public void mergeStacks() {
        Stapel<T> third = new Stapel<>();
        T topFirst = first.pop();
        T topSecond = second.pop();

        while (!(topSecond == null && topFirst == null)) {
            if (topFirst != null) {
                third.push(topFirst);
                topFirst = first.pop();
            } else if (topSecond != null) {
                third.push(topSecond);
                topSecond = second.pop();
            }
        }

        first = Stapel.reverse(third);

    }
}


