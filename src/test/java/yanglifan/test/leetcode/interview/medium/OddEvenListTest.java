package yanglifan.test.leetcode.interview.medium;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OddEvenListTest {
    private final OddEvenList sut = new OddEvenList();

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        n1.nextNode(2).nextNode(3).nextNode(4);
        ListNode oel = sut.oddEvenList(n1);
        assertThat(oel.next.val).isEqualTo(3);
        assertThat(oel.next.next.val).isEqualTo(2);
    }
}