package yanglifan.test.leetcode.interview.medium;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvg25c/
 */
public class SortColors {
    public void sortColorsBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
