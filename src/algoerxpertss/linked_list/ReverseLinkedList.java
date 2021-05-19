package algoerxpertss.linked_list;

public class ReverseLinkedList {
    public static LinkedList reverseLinkedList(LinkedList head) {
        // Write your code here.

        LinkedList currentNode = head;
        LinkedList dummyValue = head;
        while(currentNode != null){
            LinkedList nodeToReverse = currentNode;
            currentNode = currentNode.next;
            nodeToReverse.next = dummyValue;
            dummyValue = nodeToReverse;
        }
        head.next = null;
        return dummyValue;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
