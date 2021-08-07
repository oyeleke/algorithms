package elements_of_programming_interviews;

public class ReverseSublist {
    public static ListNode<Integer> reverseSublist (ListNode <Integer> L, int start, int finish) {
        if (start == finish){
            return L;
        }

        ListNode<Integer> dummyHead = new ListNode<>(-1, L);
        ListNode<Integer> subListHead = dummyHead;
        int k = 1;
        while (k++ < start){
            subListHead = subListHead.next;
        }

        ListNode<Integer>sublistItr = subListHead.next;

        while (start++ < finish){
            System.out.print("1st: ");
            printLinkedList(dummyHead);
            ListNode<Integer> temp = sublistItr.next;
            sublistItr.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
            System.out.print("2nd: ");
            printLinkedList(dummyHead);
        }

        return dummyHead.next;
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

        ListNode<Integer> ans = reverseSublist(node1, 0, 6);
        while (ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }
    }

    public static void printLinkedList(ListNode <Integer> L){
        ListNode<Integer>d = L;
        while (d != null ){
            System.out.print(d.data);
            d = d.next;
        }
        System.out.println("");
    }
}
