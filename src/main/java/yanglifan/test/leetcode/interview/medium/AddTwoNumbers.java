package yanglifan.test.leetcode.interview.medium;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode current;
        ListNode last = null;
        ListNode root = null;
        int grade = 0;
        do {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1 + v2;
            current = new ListNode((sum + grade) % 10);

            if (last != null) {
                last.next = current;
            }
            last = current;

            if (root == null) {
                root = current;
            }

            grade = sum + grade >= 10 ? 1 : 0;
        } while (l1 != null || l2 != null);

        if (grade == 1) {
            last.next = new ListNode(1);
        }

        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode nextNode(int nextVal) {
        this.next = new ListNode(nextVal);
        return next;
    }
}