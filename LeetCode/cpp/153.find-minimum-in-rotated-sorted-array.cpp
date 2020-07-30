/*
 * @lc app=leetcode id=153 lang=cpp
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (44.18%)
 * Likes:    1600
 * Dislikes: 208
 * Total Accepted:    376.2K
 * Total Submissions: 851.5K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */

// Same as the minimum number in a rotated array problem in the Coding Interviews book.
// Ref:https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
// Better than the explaination in the Coding Interviews book.

// @lc code=start
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        if (nums.size() == 0)
            return 0;
        int left = 0, right = nums.size() - 1;
        while (left < right)
        {
            if (nums[left] < nums[right])
                break;

            int mid = left + (right - left) / 2;

            if (nums[left] < nums[mid])
            {
                left = mid + 1;
            }
            else if (nums[left] > nums[mid])
            {
                right = mid;
            }
            else
                ++left;
        }
        return nums[left];
    }
};
// @lc code=end