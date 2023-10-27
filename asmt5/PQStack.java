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
        // incomplete
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    public E top() {
        // incomplete
    }

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    public E pop() {
        // incomplete
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
