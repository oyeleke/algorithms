package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class HeightBalancedTree {

    public static class BalanceStatusWithWeight{
        public boolean balanced;
        public int height;

        public BalanceStatusWithWeight(boolean isBalanced, int height) {
            this.balanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        return checkBalanced(root).balanced;
    }

    public static BalanceStatusWithWeight checkBalanced(BinaryTreeNode<Integer> root){

        if (root == null){
            return new BalanceStatusWithWeight(true, -1);
        }

        BalanceStatusWithWeight leftResult = checkBalanced(root);
        if (!leftResult.balanced){
            return leftResult;
        }

        BalanceStatusWithWeight rightResult = checkBalanced(root);
        if (!rightResult.balanced){
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithWeight(isBalanced, height);
    }
}
