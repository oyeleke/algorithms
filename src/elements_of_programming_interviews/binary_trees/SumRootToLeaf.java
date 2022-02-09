package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class
SumRootToLeaf {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree){
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialNumber) {

        if (tree == null){
            return 0;
        }

        partialNumber = partialNumber + tree.data;
        System.out.println("node "+ tree.data + " partial no "+ partialNumber);
        if (tree.right == null && tree.left == null){
            return partialNumber;
        }

        return sumRootToLeafHelper(tree.left, partialNumber) + sumRootToLeafHelper(tree.right, partialNumber);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root11 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode<Integer> root12 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode<Integer> root21 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode<Integer> root22 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode(2, root11, root12);
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode(3, root21, root22);
        BinaryTreeNode<Integer> root = new BinaryTreeNode(1, root1, root2);
        System.out.println(sumRootToLeaf(root));

    }
}
