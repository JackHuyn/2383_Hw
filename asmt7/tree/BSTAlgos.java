package asmt7.tree;

import java.util.ArrayList;
import java.lang.Integer;
import static java.lang.Math.abs;

public class BSTAlgos {
    /*
     Search the BST to find the element closest to target.
     */
    public static Position<Integer> findClosest() {
        // incomplete, use any signature you need for your implementation

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> testBST = new BinarySearchTree<>();
        Position<Integer> nodeA = testBST.addRoot(32);
        Position<Integer> nodeB = testBST.addLeft(nodeA, 24);
        Position<Integer> nodeC = testBST.addRight(nodeA, 41);
        Position<Integer> nodeD = testBST.addLeft(nodeB, 21);
        Position<Integer> nodeE = testBST.addRight(nodeB, 28);
        Position<Integer> nodeF = testBST.addLeft(nodeC, 36);
        Position<Integer> nodeG = testBST.addRight(nodeC, 47);
        Position<Integer> nodeH = testBST.addLeft(nodeD, 14);
        Position<Integer> nodeX = testBST.addLeft(nodeE, 25);
        Position<Integer> nodeY = testBST.addRight(nodeE, 31);
        Position<Integer> nodeZ = testBST.addRight(nodeF, 39);

        // Question 4
        int target = 38;
        Position<Integer> closestNode;
        // Incomplete, call your method to find and print the element closest to tgt

        System.out.println("Closest to " + target + ": " + closestNode.getElement());
    }
}



