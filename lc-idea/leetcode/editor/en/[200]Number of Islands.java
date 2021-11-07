//Given an m x n 2D binary grid grid which represents a map of '1's (land) and
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 10751 👎 273


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                ans += isIslandAround(grid, i, j) ? 1 : 0;
            }
        }
        return ans;
    }

    private boolean isIslandAround(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return false;
        }
        if (col < 0 || col >= grid[row].length) {
            return false;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            isIslandAround(grid, row + 1, col);
            isIslandAround(grid, row - 1, col);
            isIslandAround(grid, row, col + 1);
            isIslandAround(grid, row, col - 1);
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)