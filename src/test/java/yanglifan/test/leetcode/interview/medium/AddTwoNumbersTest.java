package yanglifan.test.leetcode.interview.medium;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers;

    @Before
    public void setUp() {
        addTwoNumbers = new AddTwoNumbers();
    }

    /**
     * 1 + 99
     */
    @Test
    public void t1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertThat(result.val).isEqualTo(0);
        assertThat(result.next.val).isEqualTo(0);
        assertThat(result.next.next.val).isEqualTo(1);
    }

    /**
     * 342 + 465 = 807
     */
    @Test
    public void t2() {
        ListNode l1 = new ListNode(3);
        l1.nextNode(4).nextNode(2);
        ListNode l2 = new ListNode(4);
        l2.nextNode(6).nextNode(5);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertThat(result.val).isEqualTo(7);
        assertThat(result.next.val).isEqualTo(0);
        assertThat(result.next.next.val).isEqualTo(8);
    }

    /**
     * 5 + 5 = 10
     */
    @Test
    public void t3() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertThat(result.val).isEqualTo(0);
        assertThat(result.next.val).isEqualTo(1);
    }

    /**
     * 0 + 0 = 0
     */
    @Test
    public void t4() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertThat(result.val).isEqualTo(0);
    }
}