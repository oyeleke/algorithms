package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTree;

public class LCAWithParent {

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0, BinaryTree<Integer> node1) {
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);

        // switch deepest to node0 for simplicity
        if (depth1 > depth0) {
            BinaryTree<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }

        int deptDiff = Math.abs(depth0 - depth1);

        // move deepest
        while (deptDiff-- > 0) {
            node0 = node0.parent;
        }

        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return node0;
    }

    public static int getDepth(BinaryTree<Integer> node) {
        int depth = 0;

        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

}
