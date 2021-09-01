package amazon;

import java.util.HashMap;

public class CopyRandomList {


    HashMap<Node, Node> visited = new HashMap<>();
    public Node getClonedNode(Node node) {
        if (node != null){
            if (this.visited.containsKey(node)){
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        Node oldNode = head;
        Node node = new Node(oldNode.val, null, null);
        this.visited.put(oldNode, node);

        while(oldNode != null){
            node.random = getClonedNode(oldNode.random);
            node.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            node = node.next;
        }

        return visited.get(head);
    }

    public Node copyRandomList3(Node head) {
        if (head == null){
            return null;
        }
        Node curr = head;

        //create duplicates and link them to original list
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // link the randomness
        curr = head;
        while(curr != null){

            if (curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // remove our copy
        curr = head;
        Node copy = curr.next;
        Node copyHead = copy;

        while (copy != null){
            curr.next = copy.next;

            if (curr.next != null){
                copy.next = curr.next.next;
            }
            curr = curr.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
