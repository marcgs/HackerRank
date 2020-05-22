public class IsBST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return check(node.left, min, node.data) &&
               check(node.right, node.data, max);
    }
}
