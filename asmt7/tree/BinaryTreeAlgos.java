package asmt7.tree;

import static java.lang.Math.abs;

public class BinaryTreeAlgos {
    /*
     Find the node whose element is closest to target.
     *
    public static Position<Integer> findClosest() {
        // incomplete, use any signature you need for your implementation

    }
    */
    public static Position<Integer> findClosest(Tree<Integer> tree, int target) {
        if (tree == null || tree.isEmpty()) {
            return null;
        }

        return findClosest(tree, tree.root(), target);
    }

    private static Position<Integer> findClosest(Tree<Integer> tree, Position<Integer> current, int target) {
        if (current == null) {
            return null; 
        }

        int currentElement = current.getElement();
        Position<Integer> closest = current;

        if (Math.abs(target - currentElement) < Math.abs(target - closest.getElement())) {
            closest = current;
        }

        // Iterate through positions and find left and right children
        for (Position<Integer> child : tree.children(current)) {
            Position<Integer> childClosest = findClosest(tree, child, target);

            if (childClosest != null && Math.abs(target - childClosest.getElement()) < Math.abs(target - closest.getElement())) {
                closest = childClosest;
            }
        }

        return closest;
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

        
        Position<Integer> closestNode = findClosest(testT, tgt);
        System.out.println("Element closest to " + tgt + " is " + closestNode.getElement());
    }
}


