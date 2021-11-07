//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 7788
// 👎 781


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        return (low == null ? true : root.val > low) &&
                (high == null ? true : root.val < high) &&
                isValidBST(root.left, low, root.val) &&
                isValidBST(root.right, root.val, high);
    }
}

class Solution{
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftValid = isValidBST(root.left);
        if (!isLeftValid) {
            return false;
        }

        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
