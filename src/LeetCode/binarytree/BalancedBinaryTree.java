package LeetCode.binarytree;

import LeetCode.BinaryTreeOrderLevelTraversal;
import elements_of_programming_interviews.binary_trees.HeightBalancedTree;

import static LeetCode.BinaryTreeOrderLevelTraversal.*;

public class BalancedBinaryTree {

    public static class BalanceWithHeight {
        public boolean balanced;
        public int height;

        public BalanceWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).balanced;
    }

    public BalanceWithHeight checkBalance(TreeNode root) {
        if (root == null) {
            return  new BalanceWithHeight(true, -1);
        }

        BalanceWithHeight leftResult = checkBalance(root.left);
        if (!leftResult.balanced){
            return leftResult;
        }

        BalanceWithHeight rightResult = checkBalance(root.right);
        if (!rightResult.balanced){
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height)+ 1;
        return new BalanceWithHeight(isBalanced, height);
    }

    public boolean isBalancede(TreeNode root) {
        int lh, rh;

        if (root == null) return true;

        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalancede(root.left) && isBalancede(root.right)) return true;

        return false;
    }

    public int height(TreeNode root){
        if (root == null) return 0;
        return 1+ Math.max(height(root.left), height(root.right));
    }
    }
