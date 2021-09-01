package LeetCode.binarytree;

import elements_of_programming_interviews.binary_trees.TraseversingABinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static elements_of_programming_interviews.binary_trees.TraseversingABinaryTree.*;

public class PathSum3 {
    int count = 0;
    List<Integer> list = new ArrayList<>();

    public int pathSum(TreeNode root, int targetSum) {
        pathSumHelper(root, targetSum);
        return count;
    }

    public void pathSumHelper(TreeNode root, int targetSum) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        pathSumHelper(root.left, targetSum);
        pathSumHelper(root.right, targetSum);

        System.out.println("partial Sum list " + list + " root " + root.val);

        int temp = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp += list.get(i);
            if (temp == targetSum) {
                count++;
            }
        }

        System.out.println("partial Sum list " + list + " root " + root.val + " count " + count);

        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(0, treeNode1, treeNode2);

        PathSum3 pathSum3 = new PathSum3();
        System.out.println(pathSum3.pathSumF(treeNode0, 8));
    }

    public int pathSumF(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        return pathSumHelperF(root, targetSum, map, 0);

    }

    private int pathSumHelperF(TreeNode root, int targetSum, Map<Integer, Integer> map, int partialSum) {
        if (root == null)
            return 0;

        int count = 0;
        partialSum += root.val;
        if (partialSum == targetSum){
            count++;
        }
        count += map.getOrDefault(targetSum-partialSum, 0);
        map.put(partialSum, map.getOrDefault(partialSum,0)+1);
        count += pathSumHelperF(root.left, targetSum, map, partialSum);
        count += pathSumHelperF(root.right, targetSum, map, partialSum);
        map.put(partialSum, map.get(partialSum)-1);
        return count;
    }

}
