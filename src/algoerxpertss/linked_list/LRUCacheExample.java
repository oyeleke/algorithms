package algoerxpertss.linked_list;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheExample {
    static class LRUCache {
        int maxSize;
        HashMap<String, Node> hashMap  = new HashMap<>();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();


        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (hashMap.containsKey(key)){
                Node get = hashMap.get(key);
                get.value = value;
                hashMap.replace(key, get);

            } else {
                if (hashMap.size() < maxSize){
                    Node newNode = new Node(value, key);
                    if (doublyLinkedList.head == null){
                        doublyLinkedList.setHead(newNode);
                    }else {
                        doublyLinkedList.insertBefore(doublyLinkedList.head, newNode);
                    }
                    hashMap.put(key, doublyLinkedList.head);
                } else if (hashMap.size() == maxSize){
                    Node nodeToEject = doublyLinkedList.tail;
                    doublyLinkedList.remove(nodeToEject);
                    hashMap.remove(nodeToEject.key);
                    Node newNode = new Node(value, key);
                    if (doublyLinkedList.head == null){
                        doublyLinkedList.setHead(newNode);
                    }else {
                        doublyLinkedList.insertBefore(doublyLinkedList.head, newNode);
                    }
                    hashMap.put(key, doublyLinkedList.head);
                }
            }

        }


        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if (hashMap.containsKey(key)){
                Node node = hashMap.get(key);
                doublyLinkedList.insertBefore(doublyLinkedList.head, node);
                System.out.println("getValue");
                printLinkedList();
                return new LRUResult(true, node.value);
            }
            return null;
        }

        public String getMostRecentKey() {
            // Write your code here.
            if (doublyLinkedList.head != null){
                return doublyLinkedList.head.key;
            }
            return null;
        }

        public void printLinkedList(){
            Node node = doublyLinkedList.head;;
            while(node != null){
                System.out.print(node.key+", ");
                node = node.next;
            }
            System.out.println();
        }
    }


    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

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
            if(node == head && node == tail){
                head = null;
                tail = null;
            }
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
        public String key;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, String key){
            this.value = value;
            this.key = key;
        }
    }
}
