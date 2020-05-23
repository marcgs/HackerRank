import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeHeightTest {

    @Test
    public void one_level() {
        TreeHeight.Node node = new TreeHeight.Node(1);
        assertThat(TreeHeight.height(node)).isEqualTo(1);
    }

    @Test
    public void two_levels() {
        TreeHeight.Node node = new TreeHeight.Node(2);
        node.left = new TreeHeight.Node(1);
        node.right = new TreeHeight.Node(10);
        assertThat(TreeHeight.height(node)).isEqualTo(2);
    }

    @Test
    public void three_levels() {
        TreeHeight.Node root = new TreeHeight.Node(5);

        TreeHeight.Node firstleft = root.left = new TreeHeight.Node(3);
        firstleft.left = new TreeHeight.Node(1);
        firstleft.right = new TreeHeight.Node(4);

        TreeHeight.Node firstright = root.right = new TreeHeight.Node(10);
        firstright.left = new TreeHeight.Node(8);
        firstright.right = new TreeHeight.Node(15);

        assertThat(TreeHeight.height(root)).isEqualTo(3);
    }

    @Test
    public void three_levels_uneven() {
        TreeHeight.Node root = new TreeHeight.Node(5);

        root.left = new TreeHeight.Node(3);

        TreeHeight.Node firstright = root.right = new TreeHeight.Node(10);
        firstright.left = new TreeHeight.Node(8);
        firstright.right = new TreeHeight.Node(15);

        assertThat(TreeHeight.height(root)).isEqualTo(3);
    }
}