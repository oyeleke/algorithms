package backtobackswe.trees;

public class InsertionAndDeletionIntoABST {

    TreeNode delete(TreeNode root, int val){
        if (root == null){
            return null;
        }
        if (val < root.val){
            return delete(root.left, val);
        } else if(val > root.val){
            return delete(root.right, val);
        }else {
            if (root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            TreeNode n = getNextInorderNode(root.right);
            root.val = n.val;
            delete(root.right, n.val);
        }
        return root;
    }


    TreeNode getNextInorderNode(TreeNode root){
        TreeNode leftmost = null;
        while(root.left != null){
            leftmost = root.left;
            root = root.left;
        }

        return leftmost;
    }

    TreeNode insertIntoBST(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (val < root.val){
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
