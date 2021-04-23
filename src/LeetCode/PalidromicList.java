package LeetCode;


import static LeetCode.LeetListCode.*;

public class PalidromicList {

    public static boolean isPalindrome(ListNode head) {

        ListNode first = head, second = reverseHalfLinkedList(head);

        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

    }

    public static ListNode reverseHalfLinkedList(ListNode head) {
        //get mid
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode currentNode = slow;
        ListNode previous = null;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            System.out.println("previous " + previous.val);
            System.out.println("current " + currentNode.val);
            currentNode = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        boolean ans = isPalindrome2(node1);
        System.out.println(ans);
    }

    public static boolean isPalindrome2(ListNode head) {

        if (head == null) return true;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next; // for odd palindromes;

        ListNode prev = null;

        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        slow = prev;

        while(slow != null){
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }


        return true;
    }
}


