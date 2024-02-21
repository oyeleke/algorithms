package backtobackswe.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversalWNR {

    public List<Integer> inorderTraversal(TreeNode root){
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();

        while (!s.isEmpty() || curr != null){
            if (curr !=  null){
                //go all the way down to the left root
                s.addFirst(curr);
                curr = curr.left;
            } else {
                curr = s.removeFirst();
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }

}
