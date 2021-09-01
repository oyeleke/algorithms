package elements_of_programming_interviews.binary_trees;

import elements_of_programming_interviews.BinaryTreeDepthOrder;
import elements_of_programming_interviews.BinaryTreeDepthOrder.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static elements_of_programming_interviews.binary_trees.TraseversingABinaryTree.*;

public class InOrderTraversalWithoutRecursion {

    public static List<Integer> BSTInSortedOrder (TreeNode tree) {
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode curr = tree;
        List<Integer> result = new ArrayList<>();

        while(!s.isEmpty() || curr != null){
            if (curr != null){
                s.addFirst(curr);
                curr = curr.left;
            } else {
                // go back up
                curr = s.removeFirst();
                result.add(curr.val);
                curr = curr.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6,null, null);
        TreeNode treeNode5 = new TreeNode(5,null, null);
        TreeNode treeNode4 = new TreeNode(4,null, null);
        TreeNode treeNode3 = new TreeNode(3,null, null);
        TreeNode treeNode2 = new TreeNode(2,treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(1,treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(0,treeNode1, treeNode2);

        System.out.println(BSTInSortedOrder(treeNode0));
    }
}
