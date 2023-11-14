package asmt7.tree;

import asmt7.pqueue.DefaultComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<E> extends LinkedBinaryTree<E> {
    /**
     * The comparator defining the ordering of nodes in the tree.
     */
    private Comparator<E> comp;

    /**
     * Creates an empty tree based on the natural ordering of its nodes.
     */
    public BinarySearchTree() {
        super();
        comp = new DefaultComparator<E>();
    }

    /**
     * Method for comparing two nodes
     */
    protected int compare(E a, E b) {
        return comp.compare(a, b);
    }

    /**
     * Returns node with the maximal key in the subtree rooted at node v.
     *
     * @param v a node of the tree serving as root of a subtree
     * @return node with maximal key in subtree
     */
    public Position<E> findMaximum(Position<E> v) {
        Position<E> lastParent = null;
        Position<E> walk = v;
        while (walk != null) {
            lastParent = walk;
            walk = right(walk);
        }
        return lastParent;              // we want the parent of the leaf
    }

    /**
     * Returns node with the minimal key in the subtree rooted at node v.
     *
     * @param v a node of the tree serving as root of a subtree
     * @return node with minimal key in subtree
     */
    public Position<E> findMinimum(Position<E> v) {
        Position<E> lastParent = null;
        Position<E> walk = v;
        while (walk != null) {
            lastParent = walk;
            walk = left(walk);
        }
        return lastParent;              // we want the parent of the leaf
    }

    /**
     * Returns successor of node v in the tree.
     *
     * @param v a node of the tree
     * @return successor node of node v with the tree
     */
    public Position<E> findSuccessor(Position<E> v) {
        if (right(v) != null)
            return findMinimum(right(v));  // min key in right subtree
        Position<E> j = v;
        while (!isRoot(j)) {
            Position<E> j_prev = j;
            j = parent(j);
            if (left(j) == j_prev)
                return j;
        }
        return null;
    }

    /**
     * Returns predecessor of node v in the tree.
     *
     * @param v a node of the tree
     * @return predecessor node of node v with the tree
     */
    public Position<E> findPredecessor(Position<E> v) {
        if (left(v) != null)
            return findMaximum(left(v));  // max key in left subtree
        Position<E> j = v;
        while (!isRoot(j)) {
            Position<E> j_prev = j;
            j = parent(j);
            if (right(j) == j_prev)
                return j;
        }
        return null;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given
     * snapshot using a inorder traversal
     *
     * @param p        Position serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        Position<E> leftChild = left(p);
        if (leftChild != null)
            inorderSubtree(leftChild, snapshot);
        snapshot.add(p);                       // add position p
        Position<E> rightChild = right(p);
        if (rightChild != null)
            inorderSubtree(rightChild, snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in inorder.
     *
     * @return iterable collection of the tree's positions in inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot);   // fill the snapshot recursively
        return snapshot;
    }

    /**
     * Print elements in BST according to inorder traversal.
     * @param
     * @return none
     */
    public void printInorder() {
        System.out.println("Inorder: ");
        for (Position<E> p : inorder())
            System.out.print(p.getElement() + " ");
        System.out.print("\n");
    }

    /**
     * Returns the parent Position of p (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Parent Position of p (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public Position<E> getParent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

}