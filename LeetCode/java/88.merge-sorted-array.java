/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (39.16%)
 * Likes:    2793
 * Dislikes: 4578
 * Total Accepted:    698.3K
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to
 * hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * 
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int pos = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    nums1[pos--] = nums2[j];
                    --j;
                } else {
                    nums1[pos--] = nums1[i];
                    --i;
                }
            } else if (i >= 0 && j < 0) {
                nums1[pos--] = nums1[i];
                --i;
            } else {
                nums1[pos--] = nums2[j];
                --j;
            }
        }
    }
}
// @lc code=end
