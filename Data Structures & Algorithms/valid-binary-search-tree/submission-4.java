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
        if (root == null) return true;

        if (root.left != null && max(root.left) >= root.val) return false;

        if (root.right != null && min(root.right) <= root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public int max(TreeNode root) {
        
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(
                root.val, 
                Math.max(max(root.left), 
                        max(root.right))
                );
    }

    public int min(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(
                root.val,
                Math.min(min(root.left),
                    min(root.right))
            );
    }
}
