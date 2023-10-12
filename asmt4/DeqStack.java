public class DeqStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e, top);
        top = newNode;
        size++;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E poppedElement = top.element;
        top = top.next;
        size--;
        return poppedElement;
    }
}
