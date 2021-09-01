package LeetCode;

import java.util.*;


public class BinaryTreeOrderLevelTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currNode = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        currNode.add(root);

        while (!currNode.isEmpty()) {
            Queue<TreeNode> nextNode = new LinkedList<>();
            List<Integer> currentLevel = new ArrayList<>();

            while (!currNode.isEmpty()) {
                TreeNode curr = currNode.poll();
                if (curr != null) {
                    currentLevel.add(curr.val);
                    nextNode.add(curr.left);
                    nextNode.add(curr.right);
                }
            }
            if (!currentLevel.isEmpty()) {
                result.add(currentLevel);
            }

            currNode = nextNode;
        }

        return result;
    }

    public List<List<Integer>> levelOrders(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> currNode = new LinkedList<>();
        currNode.add(root);

        while (!currNode.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = currNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = currNode.poll();
                currentLevel.add(curr.val);
                if (curr.left != null) currNode.add(curr.left);
                if (curr.right != null) currNode.add(curr.right);
            }
            if (!currentLevel.isEmpty()) {
                result.add(currentLevel);
            }
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> currNode = new LinkedList<>();
        currNode.add(root);

        while (!currNode.isEmpty()) {
            int size = currNode.size();
            Deque<Integer> currentLevel =  new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = currNode.poll();
                if (size %2 == 0) {
                    currentLevel.addFirst(curr.val);
                } else {
                    currentLevel.push(curr.val);
                }
                if (curr.left != null) currNode.add(curr.left);
                if (curr.right != null) currNode.add(curr.right);
            }

            if (!currentLevel.isEmpty()) {
                result.add(new ArrayList<>(currentLevel));
            }
        }
        return result;
    }
}
