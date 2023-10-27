package asmt5;

public class PQStack<E> implements Stack<E> {
    private Integer m;
    private UnsortedPriorityQueue<Integer, E> pq;
    public PQStack() {
        m = 0;
        pq = new UnsortedPriorityQueue<>();
    }

    public int size() { return pq.size(); }
    public boolean isEmpty() { return pq.isEmpty(); }

    /**
     * Inserts an element at the top of the stack.
     * @param e   the element to be inserted
     */
    public void push(E e) {
        // We'll use a decreasing integer key as an identifier for the elements pushed onto the stack.
        // This way, the most recently pushed element will have the highest priority.
        pq.insert(pq.size(), e);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    public E top() {
        if (isEmpty()) {
            return null;
        }
        // To get the top element, we'll find the element with the highest priority.
        Entry<Integer, E> topEntry = pq.min();
        return topEntry.getValue();
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        // To pop the top element, we'll remove the element with the highest priority.
        Entry<Integer, E> topEntry = pq.removeMin();
        return topEntry.getValue();
    }

    /**
     * Tests operations of this stack.
     */
    public static void main(String[] args) {
        PQStack<String> testStack = new PQStack<>();
        testStack.push("Ryan");
        testStack.push("Amber");
        testStack.pop();
        testStack.push("Sam");
        testStack.push("June");
        testStack.push("Brenda");
        testStack.pop();
        testStack.push("David");
        while (!testStack.isEmpty()) {
            System.out.println(testStack.pop());
        }
    }
}
