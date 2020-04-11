import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SingleLinkedListTest {

    @Test
    public void tostring() {
        SingleLinkedList llist = new SingleLinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        Assertions.assertThat(llist.toString()).isEqualTo("head->1->2->3->4");
    }

    @Test
    public void inverse() {
        SingleLinkedList llist = new SingleLinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.inverse();
        Assertions.assertThat(llist.toString()).isEqualTo("head->4->3->2->1");
    }

    @Test
    public void hasLoop_false() {
        SingleLinkedList llist = new SingleLinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.inverse();
        Assertions.assertThat(llist.hasLoop()).isFalse();
    }

    @Test
    public void hasLoop_true() {
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(null, "node3");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(node3, "node2");
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(node2, "node1");
        node3.setNextNode(node1);

        SingleLinkedList llist = new SingleLinkedList(node1);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        Assertions.assertThat(llist.hasLoop()).isTrue();
    }
}