import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsBSTTest {

    private IsBST isBST = new IsBST();

    @Test
    public void only_one_node() {
        IsBST.Node node = new IsBST.Node(1);

        assertThat(isBST.checkBST(node)).isTrue();
    }

    @Test
    public void one_level_bst() {
        IsBST.Node node = new IsBST.Node(2);
        node.left = new IsBST.Node(1);
        node.right = new IsBST.Node(10);

        assertThat(isBST.checkBST(node)).isTrue();
    }

    @Test
    public void one_level_no_bst() {
        IsBST.Node node = new IsBST.Node(2);
        node.left = new IsBST.Node(3);
        node.right = new IsBST.Node(10);

        assertThat(isBST.checkBST(node)).isFalse();
    }

    @Test
    public void three_level_bst() {
        IsBST.Node root = new IsBST.Node(5);

        IsBST.Node firstleft = root.left = new IsBST.Node(3);
        firstleft.left = new IsBST.Node(1);
        firstleft.right = new IsBST.Node(4);

        IsBST.Node firstright = root.right = new IsBST.Node(10);
        firstright.left = new IsBST.Node(8);
        firstright.right = new IsBST.Node(15);

        assertThat(isBST.checkBST(root)).isTrue();
    }

    @Test
    public void three_level_no_bst_repeated_item() {
        IsBST.Node root = new IsBST.Node(5);

        IsBST.Node firstleft = root.left = new IsBST.Node(3);
        firstleft.left = new IsBST.Node(1);
        firstleft.right = new IsBST.Node(3);

        IsBST.Node firstright = root.right = new IsBST.Node(10);
        firstright.left = new IsBST.Node(8);
        firstright.right = new IsBST.Node(15);

        assertThat(isBST.checkBST(root)).isFalse();
    }

    @Test
    public void three_level_no_bst_unordered() {
        IsBST.Node root = new IsBST.Node(5);

        IsBST.Node firstleft = root.left = new IsBST.Node(3);
        firstleft.left = new IsBST.Node(1);
        firstleft.right = new IsBST.Node(3);

        IsBST.Node firstright = root.right = new IsBST.Node(10);
        firstright.left = new IsBST.Node(11);
        firstright.right = new IsBST.Node(15);

        assertThat(isBST.checkBST(root)).isFalse();
    }
}