package LeetCode.binarytree;

import elements_of_programming_interviews.binary_trees.TraseversingABinaryTree;

import java.util.ArrayList;
import java.util.List;

import static elements_of_programming_interviews.binary_trees.TraseversingABinaryTree.*;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, 0, targetSum, new ArrayList<>(), new ArrayList<>());
    }

    public boolean hasPathSumHelper(TreeNode root, int partialSum, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {

            return false;
        }


        partialSum += root.val;
        list.add(root.val);
        System.out.println("node: " + root.val + "partial Sum: " + partialSum);
        if (root.left == null && root.right == null) {
            result.add(list);
            System.out.println("list: " + list);
            list.remove(list.size() - 1);
            return partialSum == targetSum;
        }

        boolean ans = hasPathSumHelper(root.left, partialSum, targetSum, list, result) || hasPathSumHelper(root.right, partialSum, targetSum, list, result);
        list.remove(list.size() - 1);

        return ans;
    }

    public static void main(String[] args) {

        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(0, treeNode1, treeNode2);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSumList(treeNode0, 8));
    }

    public List<List<Integer>> hasPathSumList(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        hasPathSumHelperList(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void hasPathSumHelperList(TreeNode root, int partialSum, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        partialSum += root.val;
        System.out.println("node: " + root.val + "partial Sum: " + partialSum);
        list.add(root.val);
        if (root.left == null && root.right == null && partialSum == targetSum) {
            System.out.println("list: " + list);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        hasPathSumHelperList(root.left, partialSum, targetSum, list, result);
        hasPathSumHelperList(root.right, partialSum, targetSum, list, result);
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }

    }


}

