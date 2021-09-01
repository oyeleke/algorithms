package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

public class LowestCommonAncestor {

    public static class Status {
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> ancetor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancetor;
        }

    }

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0,
                                              BinaryTreeNode<Integer> node1) {
        return LCAhelper(tree, node0, node1).ancestor;
    }

    public static Status LCAhelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node0,
                                   BinaryTreeNode<Integer> node1){

        if (tree == null){
            return new Status(0, null);
        }

        Status leftResult = LCAhelper(tree.left, node0, node1);
        if (leftResult.numTargetNodes == 2){
            return leftResult;
        }

        Status rightResult = LCAhelper(tree.right, node0, node1);
        if (rightResult.numTargetNodes == 2){
            return rightResult;
        }

        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes + (tree.equals(node0) ? 1: 0) + (tree.equals(node1)?1:0);

        return new Status(numTargetNodes, numTargetNodes== 2 ? tree : null);
    }

}
