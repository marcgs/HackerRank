public class SingleLinkedList {

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
    }

    public static class LinkedList {
        private Node head;

        public void push(Object data) {
            Node node = new Node(head, data);
            head = node;
        }

        // head->A->B->C->null
        // head  null<-A B->C->null
        // head null<-A<-B C->null
        // head null<-A<-B<-C
        // null<-A<-B<-C<-head
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
    }

}
