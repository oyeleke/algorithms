package LeetCode;

class MyLinkedList {

    /**
     * Initialize your data structure here.
     */

    class DoubleLinkedListNode {
        int val;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode(int val) {
            this.val = val;
        }
    }

    DoubleLinkedListNode headNode;
    int length;
    public MyLinkedList() {
        length = 0;
        headNode = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int i = 0;
        DoubleLinkedListNode currentNode = headNode;
        if (index < 0 || index >= this.length){
            return -1;
        }
            while (currentNode != null && i != index) {
                currentNode = currentNode.next;
                i++;
            }
        return currentNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        DoubleLinkedListNode newHead = new DoubleLinkedListNode(val);
        newHead.next = headNode;
        headNode = newHead;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoubleLinkedListNode currentNode = headNode;
        if (currentNode == null || this.length == 0) {
            addAtHead(val);
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            DoubleLinkedListNode newTailNode = new DoubleLinkedListNode(val);
            newTailNode.next = null;
            currentNode.next = newTailNode;
            newTailNode.prev = currentNode;
            length++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int i = 0;
        DoubleLinkedListNode currentNode = headNode;
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(val);
        if (length == index) {
            addAtTail(val);
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        if (index > length){
            return;
        }
        while(i != (index -1)){
            currentNode = currentNode.next;
            i++;
        }
        newNode.prev = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int i = 0;
        if (index < 0 || index >= length){
            return;
        }
        DoubleLinkedListNode currentNode = headNode;
        if (index == 0){
            headNode = currentNode.next;
            headNode.prev = null;
            length--;
        } else {
            DoubleLinkedListNode prev = null;
            while(i != index){
                prev = currentNode;
                currentNode = currentNode.next;
                i++;
            }
            DoubleLinkedListNode next = currentNode.next;
            prev.next = next;
            next.prev = prev;
            length--;
        }
    }

    public void printList() {
        DoubleLinkedListNode currentNode = headNode;
        while (currentNode != null) {
            System.out.print(currentNode.next + " ");
            currentNode = currentNode.next;
        }
    }


}
