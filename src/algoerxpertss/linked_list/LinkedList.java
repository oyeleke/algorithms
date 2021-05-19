package algoerxpertss.linked_list;

class LinkedList {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if (head == null){
                head = node;
                tail = node;
            } else {
                insertBefore(head, node);
            }
        }

        public void setTail(Node node) {
            // Write your code here.
            if (tail == null){
                setHead(node);
            } else {
                insertAfter(tail, node);
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if(nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.next = node;
            nodeToInsert.prev = node.prev;
            if (nodeToInsert.prev == null){
                head = nodeToInsert;
            }else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (nodeToInsert.next == null){
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
            // Write your code here.
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            if (position == 1){
                setHead(nodeToInsert);
                return;
            }
            int i = 0;
            Node currentNode = head;
            while (currentNode != null && i != position){
                currentNode = currentNode.next;
                i++;
            }
            if (currentNode != null) {
                insertBefore(currentNode, nodeToInsert);
            }else {
                setTail(currentNode);
            }
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node currentNode = head;
            while (currentNode != null){
                Node nodeToRemove = currentNode;
                currentNode = currentNode.next;
                if (nodeToRemove.value == value){
                    remove(nodeToRemove);
                }
            }
        }

        public void remove(Node node) {
            // Write your code here.
            if (node == head) head = head.next;
            if (node == tail) tail = tail.prev;
            removeBinding(node);
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node currentNode = head;
            while(currentNode != null){
                if(currentNode.value == value){
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }

        public void removeBinding(Node node) {
            if (node.next != null) node.next.prev = node.prev;
            if (node.prev != null) node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

