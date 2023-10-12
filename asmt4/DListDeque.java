public class DListDeque<E> implements Deque<E>{
    // instance variables of a doubly linked list to implement a deque
    /** Sentinel node at the beginning of the list */
    private Node<E> header;                    // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer;                   // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0;                      // number of elements in the list

    /** Constructs a new empty deque. */
    public DListDeque() {
        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    // public accessor methods
    /**
     * Returns the number of elements in the deque.
     * @return number of elements in the deque
     */
    public int size() { return size; }

    /**
     * Tests whether the deque is empty.
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns (but does not remove) the front element of the deque.
     * @return element at the front of the deque (or null if empty)
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getElement();
    }

    /**
     * Returns (but does not remove) the last element at the rear of the deque.
     * @return element at the rear of the deque (or null if empty)
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    // public update methods
    /**
     * Adds an element to the front of the deque.
     * @param e   the new element to add
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        size++;
    }

    /**
     * Adds an element to the rear of the deque.
     * @param e   the new element to add
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        size++;
    }

    /**
     * Removes and returns the first element from the front the deque.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = header.getNext();
        header.setNext(removedNode.getNext());
        removedNode.getNext().setPrev(header);
        size--;
        return removedNode.getElement();
    }

    /**
     * Removes and returns the last element from the rear of the deque.
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = trailer.getPrev();
        trailer.setPrev(removedNode.getPrev());
        removedNode.getPrev().setNext(trailer);
        size--;
        return removedNode.getElement();
    }

    public static void main(String[] args) {
        DListDeque<Integer> myDeque = new DListDeque<>();
        myDeque.addFirst(6);
        myDeque.addFirst(4);
        myDeque.addFirst(2);
        System.out.println(myDeque.removeFirst());
        myDeque.addLast(1);
        myDeque.addLast(3);
        myDeque.addLast(5);
        System.out.println(myDeque.removeLast());
    }
}
