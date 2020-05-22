public class IsBST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean checkBST(Node node) {
        if (!checkNode(node)) {
            return false;
        }
        if (node.left != null && !checkBST(node.left)) {
            return false;
        }
        if (node.right != null && !checkBST(node.right)) {
            return false;
        }
        return true;
    }

    boolean checkNode(Node node) {
        if (node.left != null && node.left.data >= node.data) {
            return false;
        }
        if (node.right != null && node.right.data <= node.data) {
            return false;
        }
        return true;
    }
}
