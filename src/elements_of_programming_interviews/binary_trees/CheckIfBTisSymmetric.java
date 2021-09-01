package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class CheckIfBTisSymmetric {

    public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return tree == null || checkSymmetry(tree.left, tree.right);
    }

    private static boolean checkSymmetry(BinaryTreeNode<Integer> subtree0, BinaryTreeNode<Integer> subtree1) {
        if (subtree0 == null && subtree1 == null){
            return true;
        } else if(subtree0 != null && subtree1 != null)
                 return (subtree0.data.equals(subtree1.data)) && checkSymmetry(subtree0.left, subtree1.right) && checkSymmetry(subtree0.right, subtree1.left);
        return false;
    }



}
