package backtobackswe.trees;

import java.util.ArrayList;
import java.util.List;

public class SumToPath {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        List<Boolean> list = new ArrayList<Boolean>();
        checkPath(node, targetSum, list, 0);
        return !list.isEmpty();
    }

    private int checkPath(TreeNode node, int targetSum, List<Boolean> list, int partialSum) {
        if (node == null) {
            return 0;
        }

        partialSum = partialSum + node.val;

        if (node.left == null && node.right == null) {
            if (targetSum == partialSum) {
                list.add(true);
            }
            return partialSum;
        }

        return checkPath(node.left, targetSum, list, partialSum) + checkPath(node.right, targetSum, list, partialSum);
    }

    public boolean hasPathSum2(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }

        boolean isLeaf = node.left == null && node.right == null;

        if (isLeaf && targetSum - node.val == 0) {
            return true;
        }

        return hasPathSum2(node.left, targetSum - node.val) || hasPathSum2(node.right, targetSum - node.val);
    }

}
