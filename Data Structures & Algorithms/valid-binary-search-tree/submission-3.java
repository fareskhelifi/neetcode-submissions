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
        Deque<TreeNode> q = new ArrayDeque<>();
        int result = root.val;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    result = Math.max(result, node.val);
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }   
            }
        }
        return result;
    }

    public int min(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int result = root.val;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    result = Math.min(result, node.val);
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }   
            }
        }
        return result;
    }
}
