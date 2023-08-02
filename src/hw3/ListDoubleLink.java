package hw3;
public class ListDoubleLink {
    Node head;
    Node tail;

    public void revertListDL() {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            Node previous = node.previous;
            node.next = previous;
            node.previous = next;
            if (previous == null) {
                tail = node;
            }
            if (next ==null) {
                head = node;
            }
            node = next;
        }
    }

    public class Node {
        Node next;
        Node previous;
    }

}


