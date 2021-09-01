package LeetCode.binarytree;

import LeetCode.BinaryTreeOrderLevelTraversal;

import static LeetCode.BinaryTreeOrderLevelTraversal.*;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetricHelper(root.left, root.right);
    }

    public boolean symmetricHelper(TreeNode subTree0, TreeNode subTree1){
        if(subTree0 == null && subTree1 == null){
            return true;
        } else if(subTree0 != null && subTree1 != null){
            return ((subTree0.val == subTree1.val)&& symmetricHelper(subTree0.left, subTree1.right) && symmetricHelper(subTree0.right, subTree1.left));
        }

        return false;
    }
}
