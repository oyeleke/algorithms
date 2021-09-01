package elements_of_programming_interviews.binary_trees;

import LeetCode.BinaryTreeOrderLevelTraversal;
import elements_of_programming_interviews.BinaryTreeDepthOrder;

public class TraseversingABinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void treeTraversal(TreeNode root){
        if (root != null){

            //pre order
            //System.out.println("pre order "+ root.val);
            treeTraversal(root.left);

            //Inorder
            System.out.println("In order "+ root.val);
            treeTraversal(root.right);

            //post order
            //System.out.println("post order "+ root.val);


        }
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6,null, null);
        TreeNode treeNode5 = new TreeNode(5,null, null);
        TreeNode treeNode4 = new TreeNode(4,null, null);
        TreeNode treeNode3 = new TreeNode(3,null, null);
        TreeNode treeNode2 = new TreeNode(2,treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(1,treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(0,treeNode1, treeNode2);

        treeTraversal(treeNode0);
    }
}
