public class SingleLinkedList {

    private Node head;

    public SingleLinkedList() {
    }

    SingleLinkedList(Node head) {
        this.head = head;
    }

    public void push(Object data) {
        Node node = new Node(head, data);
        head = node;
    }

    public void inverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (slow.nextNode != null && fast.nextNode != null && fast.nextNode.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("head");
        Node current = head;
        while (current != null) {
            sb.append("->").append(current.data);
            current = current.nextNode;
        }
        return sb.toString();
    }

    public static class Node {
        private Node nextNode;
        private Object data;

        public Node(Node nextNode, Object data) {
            this.nextNode = nextNode;
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
