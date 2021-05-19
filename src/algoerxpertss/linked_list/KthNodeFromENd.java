package algoerxpertss.linked_list;

public class KthNodeFromENd {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        int length = 0;
        LinkedList currentNode = head;
        length++;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        int distFromFront = length - k;
        if (distFromFront < 0){
            return;
        } else if(distFromFront == 0){
           head.value = 1;
           head.next = head.next.next;
        } else {
            int i = 1;
            LinkedList node = head;
            while(i != distFromFront){
                i++;
                node = node.next;
            }
            node.next = node.next.next;
        }
    }


    static class LinkedList {
        int value;
        LinkedList next = null;


        public LinkedList(int value) {
            this.value = value;
        }
    }
}
