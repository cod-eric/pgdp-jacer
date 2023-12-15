import java.util.Collection;

public class KleiderstangeDeque<T> {
    DequeueElement<T> first;
    DequeueElement<T> last;

    /**
     * appends the new element at the front
     *
     * @param element value of the new element
     */
    public void addFirst(T element) {
        DequeueElement<T> neues = new DequeueElement<>(element);
        if (first == null) {
            first = neues;
            last = neues;
        } else {
            neues.next = first;
            first = neues;
        }
    }

    /**
     * adds all elements of the collection in front
     *
     * @param elements Collection of elements to append
     */
    public void addFirst(Collection<T> elements) {
        for (T t : elements) {
            addFirst(t);
        }
    }

    /**
     * removes the first occurence of given element from the list
     *
     * @param element element to be removed
     */
    public void removeFirstOccurrence(T element) {
        if (first == null) ;
        else if (first.next == null && element.equals(first.value)) {
            first = null;
            last = null;

        } else {

            DequeueElement<T> current = first;
            DequeueElement<T> previous = null;


            while (current != null) {
                if (element.equals(current.value)) {
                    T content = current.value;
                    if (current.next != null) {
                        current.next.prev = previous;
                    }
                    if (previous != null) {
                        previous.next = current.next;
                    }
                    break;
                }

                previous = current;
                current = current.next;
            }


        }
    }

    /**
     * appends the element to the end of the list
     *
     * @param element element to be appended
     */
    public void addLast(T element) {
        DequeueElement<T> neues = new DequeueElement<>(element);
        if (first == null) {
            first = neues;
            last = neues;
        } else {
            neues.prev = last;
            last = neues;
        }
    }

    /**
     * appends all elements to the end of the dequeue
     *
     * @param elements collection of elements to append
     */
    public void addLast(Collection<T> elements) {
        for (T t : elements) {
            addLast(t);
        }
    }

    /**
     * removes last occurence of given element
     *
     * @param element element to remove
     */
    public void removeLastOccurrence(T element) {
        if (last == null) ;
        else if (last.prev == null && element.equals(last.value)) {
            first = null;
            last = null;

        } else {

            DequeueElement<T> current = last;
            DequeueElement<T> next = null;


            while (current != null) {
                if (element.equals(current.value)) {
                    T content = current.value;
                    if (current.prev != null) {
                        current.prev.next = next;
                    }
                    if (next != null) {
                        next.prev = current.prev;
                    }
                    break;
                }

                next = current;
                current = current.prev;
            }

        }
    }

    /**
     * checks if element is contained in dequeue
     *
     * @param element element to check for
     * @return returns true if element is contained
     */
    public boolean contains(T element) {
        DequeueElement<T> current = first;
        while (current != null) {
            if (element.equals(current.value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * checks if all elements are contained
     *
     * @param elements collection of elements
     * @return returns if all elements are in the dequeue
     */
    public boolean containsAll(Collection<T> elements) {
        for (T t : elements) {
            if (!contains(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * class for dequeue elements
     *
     * @param <T> type saved in a dequeue element
     */
    private static class DequeueElement<T> {
        DequeueElement<T> prev;
        DequeueElement<T> next;

        T value;

        public DequeueElement(T value) {
            this.value = value;
        }
    }

}
