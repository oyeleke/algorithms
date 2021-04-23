package elements_of_programming_interviews;

public class CyclicRightShiftLinkedList {

    public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L, int k) {
        if (L == null){
            return L;
        }

        int n = 1;
        ListNode<Integer> tail = L;

        while(tail.next != null){
            tail = tail.next;
            n++;
        }

        k %= n;

        if (k == 0){
            return L;
        }

        tail.next = L; //turn it to a cyclic
        int nextStepsToHead = n - k;
        ListNode<Integer>newTail = tail;
        while (nextStepsToHead-- > 0){
            newTail = newTail.next;
        }

        ListNode<Integer> newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }
}
