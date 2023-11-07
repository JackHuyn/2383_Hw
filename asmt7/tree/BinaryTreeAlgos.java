package asmt7.tree;

import static java.lang.Math.abs;

public class BinaryTreeAlgos {
    /*
     Find the node whose element is closest to target.
     */
    public static Position<Integer> findClosest() {
        // incomplete, use any signature you need for your implementation

    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> testT = new LinkedBinaryTree<>();
        Position<Integer> nodeA = testT.addRoot(32);
        Position<Integer> nodeB = testT.addLeft(nodeA, 24);
        Position<Integer> nodeC = testT.addRight(nodeA, 36);
        Position<Integer> nodeD = testT.addLeft(nodeB, 21);
        Position<Integer> nodeE = testT.addRight(nodeB, 28);
        Position<Integer> nodeF = testT.addLeft(nodeC, 41);
        Position<Integer> nodeG = testT.addRight(nodeC, 39);
        Position<Integer> nodeH = testT.addLeft(nodeD, 14);
        Position<Integer> nodeX = testT.addLeft(nodeE, 25);
        Position<Integer> nodeY = testT.addRight(nodeE, 33);
        Position<Integer> nodeZ = testT.addRight(nodeF, 47);

        // Question 3
        int tgt = 29;
        Position<Integer> closestNode;
        // Incomplete, call your method to find and print the element closest to tgt

        System.out.println("Element closest to " + tgt + " is " + closestNode.getElement());
    }
}


