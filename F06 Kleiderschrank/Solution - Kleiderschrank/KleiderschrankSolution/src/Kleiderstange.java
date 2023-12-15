public class Kleiderstange<T> {

    Kleiderhaken<T> erstes;

    /**
     * Method to add a new Element at the beginning of the Linked List
     *
     * @param newEl Element to be added
     */
    public void add(T newEl) {

        Kleiderhaken<T> neuerHaken = new Kleiderhaken<>(newEl);
        if (erstes == null) {
            erstes = neuerHaken;
        } else {
            neuerHaken.naechstes = erstes;
            erstes = neuerHaken;
        }
    }

    /**
     * Recursive Method to remove nth element
     *
     * @param n index to remove
     * @return value of removed Element
     */
    public T removeNthRec(int n) {
        if (n < 0) return null;
        T returnVal = erstes.findNth(n);
        erstes = erstes.removeNth(n);
        return returnVal;
    }

    /**
     * Non-recursive Method to remove nth element
     *
     * @param n index to remove
     * @return value of removed Element
     */
    public T removeNthIt(int n) {
        if (n < 0) return null;
        else if (erstes == null) return null;

        T returnValue = null;
        Kleiderhaken<T> current = erstes;
        int counter = 1;

        if (n == 0) {
            returnValue = erstes.inhalt;
            erstes = erstes.naechstes;
            return returnValue;
        }


        while (current.naechstes != null) {
            if (counter++ == n) {
                returnValue = current.naechstes.inhalt;
                current.naechstes = current.naechstes.naechstes;
                return returnValue;
            }
            current = current.naechstes;
        }

        return returnValue;
    }

    /**
     * Non-Recursive Method to filter all elements of Type Socke
     */
    public void filterSocksIterative() {
        if (erstes == null) return;

        Kleiderhaken<T> current = erstes;
        while (current.naechstes != null) {
            if (current.naechstes.inhalt instanceof Socke) {
                current.naechstes = current.naechstes.naechstes;
            }
            current = current.naechstes;
        }
    }

    /**
     * Recursive Method to filter all elements of Type Socke
     */
    public void filterSocksRec() {
        erstes = erstes.filterSocks();
    }

    /**
     * Recursive Method to insert element at given index
     *
     * @param n       index to insert
     * @param element element to insert
     */
    public void insertAtRec(int n, T element) {
        erstes = erstes.insertAt(n, element);
    }

    /**
     * Non-Recursive Method to insert element at given index
     *
     * @param n       index to insert
     * @param element element to insert
     */
    public void insertAtIt(int n, T element) {
        if (n < 0) return;

        Kleiderhaken<T> current = erstes;
        int i = 1;
        Kleiderhaken<T> neuerHaken = new Kleiderhaken<>(element);

        if (n == 0) {
            neuerHaken.naechstes = erstes;
            erstes = neuerHaken;
        } else {
            while (current != null) {
                if (i++ == n) {
                    neuerHaken.naechstes = current.naechstes;
                    current.naechstes = neuerHaken;
                    break;
                }
                current = current.naechstes;
            }

        }

    }

    /**
     * Non-Recursive contains method for List
     *
     * @param element element to check for
     * @return contains element
     */
    public boolean containsIt(T element) {
        Kleiderhaken<T> current = erstes;
        while (current != null) {
            if (current.inhalt.equals(element)) {
                return true;
            }
            current = current.naechstes;
        }
        return false;
    }

    /**
     * Recursive contains method for List
     *
     * @param element element to check for
     * @return contains element
     */
    public boolean containsRec(T element) {
        if (erstes == null) return false;
        else return erstes.contains(element);
    }

    /**
     * Filters all Socks from given list, that don't have a counterpart in the given list
     *
     * @param kleider List to be filtered
     * @return Kleiderstange with elements of Type Socke with counterpart in List
     */
    public static Kleiderstange<Socke>
    filterSingleSocks(Kleiderstange<Socke> kleider) {
        Kleiderhaken<Socke> current = kleider.erstes;
        if (current == null) return kleider;

        while (current != null && current.naechstes != null) {
            Socke counterpart = current.naechstes.inhalt.getCounterpart();
            if (kleider.containsRec(counterpart)) {
                current = current.naechstes;
            } else {
                current = current.naechstes.naechstes;
            }
        }

        Socke counterpartFirst = kleider.erstes.inhalt.getCounterpart();
        if (kleider.containsRec(counterpartFirst)) {
            return kleider;
        } else {
            kleider.erstes = kleider.erstes.naechstes;
            return kleider;
        }
    }


    /**
     * Class for the elements of the Kleiderstange
     *
     * @param <T> value saved in each Element
     */
    private static class Kleiderhaken<T> {
        private T inhalt;
        private Kleiderhaken<T> naechstes;

        /**
         * Constructor
         *
         * @param inhalt value of the current element
         */
        public Kleiderhaken(T inhalt) {
            this.inhalt = inhalt;
        }

        /**
         * removes all elements of type Socke
         *
         * @return filtered rest of list
         */
        public Kleiderhaken<T> filterSocks() {
            if (this.inhalt instanceof Socke) {
                return naechstes.filterSocks();
            } else {
                naechstes = naechstes.filterSocks();
                return this;
            }
        }


        /**
         * inserts n spots after the current Kleiderhaken
         *
         * @param n       distance to the insert spot
         * @param element element to insert
         * @return list after insert
         */
        public Kleiderhaken<T> insertAt(int n, T element) {
            if (n < 0) return null;
            else if (n == 0) {
                Kleiderhaken<T> neuerHaken = new Kleiderhaken<>(element);
                neuerHaken.naechstes = this;
                return neuerHaken;
            } else {
                this.naechstes = naechstes.insertAt(n - 1, element);
                return this;
            }
        }

        /**
         * finds element n spots after current
         *
         * @param n distance to the searched element
         * @return value of element at given position
         */
        public T findNth(int n) {
            if (n < 0) {
                return null;
            } else if (n == 0) {
                return this.inhalt;
            } else if (naechstes != null) {
                return naechstes.findNth(n - 1);
            } else {
                return null;
            }
        }

        /**
         * removes element n spots after given position
         *
         * @param n number of steps after current
         * @return filtered list
         */
        public Kleiderhaken<T> removeNth(int n) {
            if (n < 0) {
                return null;
            } else if (n == 0) {
                return naechstes;
            } else {
                naechstes = naechstes.removeNth(n - 1);
                return this;
            }
        }

        /**
         * checks if element follows after the current
         *
         * @param element element to check
         * @return boolean if its contained
         */
        public boolean contains(T element) {
            if (this.inhalt.equals(element)) return true;
            else if (naechstes == null) return false;
            else return naechstes.contains(element);
        }
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
