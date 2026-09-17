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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if  (root == null) return result;
        bfs(root, result);
        return result;
    }

    private void bfs(TreeNode node, List<Integer> result) {
        result.add(node.val);
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        
        q.offer(new Pair<>(node, 1));
        int lastHeight = 0;

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> current = q.poll();
            TreeNode n = current.getKey();
            int height = current.getValue();

            if (n.right != null) {
                if (height > lastHeight) {
                    result.add(n.right.val);
                    lastHeight++;
                } 
                q.offer(new Pair<>(n.right, height + 1));
            }
            if (n.left != null && n.right != null) {
                q.offer(new Pair<>(n.left, height + 1));
            }
            if (n.left != null && n.right == null) {
                if (height > lastHeight) {
                    result.add(n.left.val);
                    lastHeight++;
                } 
                q.offer(new Pair<>(n.left, height + 1));
            }
        } 
    }
} 
