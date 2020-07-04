package yanglifan.test.leetcode.interview.easy;

/**
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/23/
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }
}
