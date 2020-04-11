import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    @Test
    public void tostring() {
        SingleLinkedList.LinkedList llist = new SingleLinkedList.LinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        Assertions.assertThat(llist.toString()).isEqualTo("head->1->2->3->4");
    }

    @Test
    public void inverse() {
        SingleLinkedList.LinkedList llist = new SingleLinkedList.LinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.inverse();
        Assertions.assertThat(llist.toString()).isEqualTo("head->4->3->2->1");
    }
}