package yanglifan.test.leetcode.interview.easy;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int len = removeDuplicates.removeDuplicates(new int[]{1, 1, 2});
        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
                nums[len - 1] = nums[i];
            }
        }
        return len;
    }
}
