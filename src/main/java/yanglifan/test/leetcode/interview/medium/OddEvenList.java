package yanglifan.test.leetcode.interview.medium;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        ListNode oddHead = null;
        ListNode odd = null;
        ListNode evenHead = null;
        ListNode even = null;

        int i = 1;
        while (node != null) {
            if (i == 1) {
                oddHead = node;
                odd = node;
                node = node.next;
                i++;
                continue;
            }

            if (i == 2) {
                evenHead = node;
                even = node;
                node = node.next;
                i++;
                continue;
            }

            if (i++ % 2 == 1) {
                odd.next = node;
                odd = node;
            } else {
                if (even != null) {
                    even.next = node;
                }
                even = node;

            }

            node = node.next;
        }

        odd.next = evenHead;
        if (even != null)
            even.next = null;
        return oddHead;
    }
}