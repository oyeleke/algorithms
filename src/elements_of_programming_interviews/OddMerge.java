package elements_of_programming_interviews;

import java.util.Arrays;
import java.util.List;

public class OddMerge {
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
        if (L == null) {
            return L;
        }
        ListNode<Integer> evenDummyHead = new ListNode<>(0, null), oddDummyHead = new ListNode<>(0, null);
        List<ListNode<Integer>> tails = Arrays.asList(evenDummyHead, oddDummyHead);
        int turn = 0;
        for (ListNode<Integer> iter = L; iter != null; iter = iter.next) {
            tails.get(turn).next = iter;
            tails.set(turn,
                    tails.get(turn).next);
            turn ^= 1;
            System.out.println("turns "+ turn);
        }
        tails.get(1).next = null;
        tails.get(0).next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    public static void main (String [] args){
        ListNode<Integer>node1 = new ListNode<>(0);
        ListNode<Integer>node2 = new ListNode<>(1);
        ListNode<Integer>node3 = new ListNode<>(2);
        ListNode<Integer>node4 = new ListNode<>(3);
        ListNode<Integer>node5 = new ListNode<>(4);
        ListNode<Integer>node6 = new ListNode<>(5);
        ListNode<Integer>node7 = new ListNode<>(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode<Integer> ans = evenOddMerge(node1);
        while (ans.next != null){
            ans = ans.next;
            System.out.println(ans.data);
        }
    }
}

