package algoerxpertss.linked_list;

public class MergeLinkedList {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.
        LinkedList headOneNode = headOne;
        LinkedList headTwoNode = headTwo;
        LinkedList head = new LinkedList(-1);
        LinkedList dummheadNode = head;

        while (headOneNode != null && headTwoNode != null){
            if (headOneNode.value < headTwoNode.value){
                dummheadNode.next = headOneNode;
                headOneNode = headOneNode.next;
            } else {
                dummheadNode.next = headTwoNode;
                headTwoNode = headTwoNode.next;
            }
            dummheadNode = dummheadNode.next;
        }

        if (headOneNode != null){
            dummheadNode.next = headOneNode;
        }
        if (headTwoNode != null){
            dummheadNode.next = headTwoNode;
        }
        return head.next;
    }
}
