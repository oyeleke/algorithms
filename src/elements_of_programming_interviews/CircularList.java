package elements_of_programming_interviews;

public class CircularList {

    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println(slow.data +" slow fast " + fast.data);
            if (slow == fast) {
// There is a cycle, so now let’s calculate the cycle length.
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);
// Finds the start of the cycle.
                ListNode<Integer> cycleLenAdvancedlter = head;
// cycleLenAdvancedlter pointer advances cycleLen first.
                System.out.println("cyclen first"+ cycleLen);
                while (cycleLen-- > 0) {
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }
                ListNode<Integer> iter = head;
// Both iterators advance in tandem.
                while (iter != cycleLenAdvancedlter) {
                    iter = iter.next;
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }
                return iter; // iter is the start of cycle. }
            }
        }
        return null;
    }

    public static ListNode<Integer> hasCycle2(ListNode<Integer> head){

        ListNode<Integer> fast = head, slow = head;

        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;

                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main (String [] args){
        ListNode<Integer>node1 = new ListNode<>(10);
        ListNode<Integer>node2 = new ListNode<>(12);
        ListNode<Integer>node3 = new ListNode<>(14);
        ListNode<Integer>node4 = new ListNode<>(16);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        ListNode<Integer> ans = hasCycle(node1);
        System.out.println(ans.data);
    }
}
