package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class HasPathSum {

    public static boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum) {
       return hasPathSumHelper(tree, 0, targetSum);
    }

    private static boolean hasPathSumHelper(BinaryTreeNode<Integer> tree, int partialSum, int targetSum) {
        if (tree == null){
            return false;
        }

        partialSum += tree.data;

        if (tree.left == null && tree.right == null){
            return partialSum == targetSum;
        }

        return hasPathSumHelper(tree.left, partialSum, targetSum) || hasPathSumHelper(tree.right, partialSum, targetSum);
    }
}
