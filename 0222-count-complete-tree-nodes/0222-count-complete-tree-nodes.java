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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int totalDepth = getDepth(root);
        int rightDepth = getDepth(root.right);
        
        if (rightDepth + 1 == totalDepth) {
            return (1 << totalDepth - 1) + countNodes(root.right);
        }
        return (1 << totalDepth - 2) + countNodes(root.left);
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getDepth(root.left);
    }
}