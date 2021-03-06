////Problem : Array Partition I
////
////Problem Description:
////  
////  Given an array of 2n integers, your task is to group these integers into 
////  n pairs of integer, say(a1, b1), (a2, b2), ..., (an, bn) which makes sum
////  of min(ai, bi) for all i from 1 to n as large as possible.
////  
////  Example 1:
////  Input: [1,4,3,2]
////  Output: 4
////  Explanation : n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
////  
////  Note :
////  1. n is a positive integer, which is in the range of [1, 10000].
////  2. All the integers in the array will be in the range of[-10000, 10000].
//
//#include <iostream>
//#include <string>
//#include <vector>
//#include <cassert>
//#include <algorithm>
//
//class Solution {
//public:
//	int arrayPairSum(std::vector<int>& nums) {
//		int sum = 0;
//		std::sort(nums.begin(), nums.end());
//		for (int i = 0; i < nums.size() / 2; ++i)
//			sum += nums[2*i];
//		return sum;
//	}
//};
//
//int main() {
//	std::vector<std::vector<int>> testCase = { {1,4,3,2} };
//	std::vector<int> testAns = { 4 };
//	for (int i = 0; i < testCase.size(); ++i) {
//		bool res = Solution().arrayPairSum(testCase[i]) == testAns[i];
//		if (res) {
//			std::cout << "Test case " << i << " passed.\n";
//		}
//		else {
//			std::cout << "Test case " << i << " failed.\n";
//		}
//	}
//	std::cin.get();
//	return 0;
//}