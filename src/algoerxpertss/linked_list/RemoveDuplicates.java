package algoerxpertss.linked_list;

public class RemoveDuplicates {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList pointer1 = linkedList;
        LinkedList pointer2 = linkedList;

        while (pointer1 != null){
            if (pointer2.value != pointer1.value){
                pointer2.next = pointer1;
                pointer2 = pointer1;
            }
            pointer1 = pointer1.next;
        }
        assert pointer2 != null;
        pointer2.next = null;
        return linkedList;
    }
}
