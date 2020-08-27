package yanglifan.test.leetcode.interview.medium;

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
