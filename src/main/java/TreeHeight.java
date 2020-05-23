public class TreeHeight {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        return traverse(root, 0);
    }

    private static int traverse(Node node, int level) {
        if (node == null) {
            return level;
        }

        int leftL = traverse(node.left, level + 1);
        int leftR = traverse(node.right, level + 1);
        return Math.max(leftL, leftR);
    }
}
