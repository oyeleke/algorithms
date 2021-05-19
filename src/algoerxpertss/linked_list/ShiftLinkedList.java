package algoerxpertss.linked_list;

public class ShiftLinkedList {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        // Write your code here.
        LinkedList currentNode = head;
        int length = 0;
        while (currentNode.next != null){
            length++;
            currentNode = currentNode.next;
        }
        length++;
        currentNode.next = head;

        int newPosition = k % length;
        int i = 0;
        LinkedList currNode = head;
        while (i != newPosition){
            currNode = currNode.next;
            i++;
        }
        head = currNode.next;
        currNode.next = null;
        return head;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
