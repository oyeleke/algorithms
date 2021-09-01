package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTree;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class ComputeTheSuccessor {

    public static BinaryTree<Integer> findSuccessor (BinaryTree<Integer > node) {
        BinaryTree<Integer> iter = node;

        //check if the node has a right tree
        if (iter.right != null){
            iter = iter.right;

            while (iter.left != null){
                iter = iter.left;
            }
            return iter;
        }

        while (iter.parent != null && iter.parent.right == iter){
            iter = iter.parent;
        }

        return iter.parent;
    }
}
