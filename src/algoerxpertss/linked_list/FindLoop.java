package algoerxpertss.linked_list;

public class FindLoop {
    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        LinkedList slow = head;
        LinkedList fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                isCycle = true;
                break;
            }
        }

        if (isCycle){
            fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    break;
                }
            }
        } else {
            return null;
        }
        return slow;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
