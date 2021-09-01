package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;
import elements_of_programming_interviews.binary_trees.TraseversingABinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public static List<Integer> preorderTraversal (TreeNode tree) {
        Deque<TreeNode> path = new LinkedList<>();
        path.addFirst(tree);
        List<Integer> results = new ArrayList<>();
        while (!path.isEmpty()){
            TreeNode curr = path.removeFirst();

            if (curr != null){

                results.add(curr.val);
                path.addFirst(curr.right);
                path.addFirst(curr.left);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(0, treeNode1, treeNode2);

        System.out.println(preorderTraversal(treeNode0));
    }
}
