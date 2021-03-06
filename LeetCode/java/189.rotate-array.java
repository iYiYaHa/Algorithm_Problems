/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if (k < 0)
            return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        if (k < 0)
            return;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            tmp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = tmp[i];
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        if (k < 0)
            return;
        k = k % nums.length;
        int cnt = 0;

        for (int i = 0; cnt < nums.length; ++i) {
            int begPos = i;
            int prev = nums[i];
            do {
                int next = (i + k) % nums.length;

                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;

                i = next;
                ++cnt;
            } while (begPos != i);

        }
    }
}

// @lc code=end
