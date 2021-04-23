package elements_of_programming_interviews;

public class ReverseLinkedList {

    public  static ListNode<Integer> reverseHalfLinkedList(ListNode<Integer> head){

        //get mid
        ListNode<Integer> slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode<Integer> currentNode = slow;
        ListNode<Integer> previous = null;

        while (currentNode != null){
            ListNode<Integer>next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            System.out.println("previous "+previous.data);
            System.out.println("current "+currentNode.data);
            currentNode = next;
        }
        return previous;
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

        ListNode<Integer> ans = reverseHalfLinkedList(node1);
        while (ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }
    }
}
