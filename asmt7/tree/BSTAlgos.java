package asmt7.tree;

import java.util.ArrayList;
import java.lang.Integer;
import static java.lang.Math.abs;

public class BSTAlgos {
    public static Position<Integer> findClosest(BinarySearchTree<Integer> bst, int target) {
        if (bst == null || bst.isEmpty()) {
            return null;
        }

        return findClosestRecursive(bst, bst.root(), target, null);
    }

    private static Position<Integer> findClosestRecursive(BinarySearchTree<Integer> bst, Position<Integer> node, int target, Position<Integer> closest) {
        if (node == null) {
            return closest;
        }

        int currentElement = node.getElement();

        // Update the closest node if the current node is closer to the target
        if (closest == null || Math.abs(target - currentElement) < Math.abs(target - closest.getElement())) {
            closest = node;
        }

        // Determine whether to search in the left or right subtree
        if (target < currentElement) {
            return findClosestRecursive(bst, bst.left(node), target, closest);
        } else if (target > currentElement) {
            return findClosestRecursive(bst, bst.right(node), target, closest);
        } else {
            // If the target is equal to the current element, no need to search further
            return closest;
        }
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
        Position<Integer> closestNode = findClosest(testBST, target);
        // Incomplete, call your method to find and print the element closest to tgt

        System.out.println("Closest to " + target + ": " + closestNode.getElement());
    }
}



