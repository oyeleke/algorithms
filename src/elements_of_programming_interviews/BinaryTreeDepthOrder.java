package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDepthOrder {
    public static class BinaryTreeNode<T> {
        public T data;
        public int size;
        public BinaryTreeNode<T> left, right;
    }

    public static class BinaryTree<T> {
        public T data;
        public BinaryTree<T> left, right, parent;
    }


    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {

        Queue<BinaryTreeNode<Integer>> currNode = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        currNode.add(tree);

        while (!currNode.isEmpty()){
            List<Integer> thisLevel = new ArrayList<>();
            Queue<BinaryTreeNode<Integer>> nextNodes = new LinkedList<>();

            while (!currNode.isEmpty()){
                BinaryTreeNode<Integer> curr = currNode.poll();
                if (curr != null){
                    thisLevel.add(curr.data);
                    nextNodes.add(curr.left);
                    nextNodes.add(curr.right);
                }
            }

            if (!thisLevel.isEmpty()){
                result.add(thisLevel);
            }
            currNode = nextNodes;
        }

        return result;
        }
    }


