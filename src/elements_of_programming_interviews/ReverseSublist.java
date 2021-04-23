package elements_of_programming_interviews;

public class ReverseSublist {
    public static ListNode<Integer> reverseSublist (ListNode <Integer> L, int start, int finish) {
        if (start == finish){
            return L;
        }

        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> subListHead = dummyHead;
        int k = 1;
        while (k++ < start){
            subListHead = subListHead.next;
        }

        ListNode<Integer>sublistItr = subListHead.next;

        while (start++ < finish){
            ListNode<Integer> temp = sublistItr.next;
            sublistItr.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }

        return dummyHead.next;
    }
}
