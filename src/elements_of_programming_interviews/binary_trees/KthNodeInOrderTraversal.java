package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class KthNodeInOrderTraversal {
    public static BinaryTreeNode<Integer> findKthNodeBinaryTree(BinaryTreeNode<Integer> tree, int k){

        BinaryTreeNode<Integer> iter = tree;

        while (iter != null){

            int leftSize = iter.left != null ? iter.size : 0;
            if (leftSize + 1 < k){
                k -= (iter.size + 1);
                iter = iter.right;
            } else if (leftSize == k -1){
                return iter;
            } else {
                iter = iter.left;
            }
        }
        return  null;
    }
}
