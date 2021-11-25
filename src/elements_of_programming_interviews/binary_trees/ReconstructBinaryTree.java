package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTree;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

import java.util.List;

public class ReconstructBinaryTree {

    static int index;
    public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
        index = 0;
        return reconstructPreorderHelper(preorder);
    }

    private static BinaryTreeNode<Integer> reconstructPreorderHelper(List<Integer> preorder) {
        Integer nodeKey = preorder.get(index);
        index++;

        if (nodeKey == null){
            return null;
        }

        System.out.println("left "+ index);
        BinaryTreeNode<Integer> leftSubtree = reconstructPreorderHelper(preorder);
        System.out.println("right "+ index);
        BinaryTreeNode<Integer> rightSubtree = reconstructPreorderHelper(preorder);
        return new BinaryTreeNode<>(nodeKey, leftSubtree, rightSubtree);
    }


    public static void main(String[] args) {

    }
}
