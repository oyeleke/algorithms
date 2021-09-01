package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class SumRootToLeaf {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree){
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialNumber) {

        if (tree == null){
            return 0;
        }

        partialNumber = partialNumber *2 + tree.data;
        if (tree.right == null && tree.left == null){
            return partialNumber;
        }

        return sumRootToLeafHelper(tree.left, partialNumber) + sumRootToLeafHelper(tree.right, partialNumber);
    }
}
