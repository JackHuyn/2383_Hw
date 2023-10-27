package asmt5;

public class PQQueue<E> implements Queue<E>{
    private Integer maxKey;
    private UnsortedPriorityQueue<Integer, E> pq;
    public PQQueue() {
        maxKey = 0;
        pq = new UnsortedPriorityQueue<>();
    }

    public int size() { return pq.size(); }
    public boolean isEmpty() { return pq.isEmpty(); }

    /**
     * Inserts an element at the rear of the queue.
     * @param e  the element to be inserted
     */
    public void enqueue(E e) {
        // incomplete
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    public E first() {
        // incomplete
    }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
    public E dequeue() {
        // incomplete
    }

    /**
     * Tests operations of this queue.
     */
    public static void main(String[] args) {
        PQQueue<String> testQ = new PQQueue<>();
        testQ.enqueue("Ryan");
        testQ.enqueue("Amber");
        testQ.enqueue("Sam");
        testQ.dequeue();
        testQ.enqueue("June");
        testQ.enqueue("Mike");
        testQ.enqueue("Amanda");
        testQ.dequeue();
        testQ.dequeue();
        while (!testQ.isEmpty()) {
            System.out.println(testQ.dequeue());
        }
    }

}
