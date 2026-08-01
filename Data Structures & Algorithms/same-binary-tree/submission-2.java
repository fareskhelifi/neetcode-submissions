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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        Deque<TreeNode> pQ = new ArrayDeque<>();
        Deque<TreeNode> qQ = new ArrayDeque<>();

        pQ.offer(p);
        qQ.offer(q);

        while (!pQ.isEmpty() && !qQ.isEmpty()) {
            int sizeP = pQ.size();
            int sizeQ = qQ.size();

            TreeNode nodeP = pQ.poll();
            TreeNode nodeQ = qQ.poll();
            System.out.println(nodeP.val);
            System.out.println(nodeQ.val);
            if (nodeP.val != nodeQ.val) return false;
            
            System.out.println(sizeP + ", " + sizeQ);
            if (sizeP != sizeQ) return false;
            for (int i = 0; i < sizeP; i++) {
                if ((nodeP.left == null && nodeQ.left != null) || 
                (nodeP.left != null && nodeQ.left == null)) {
                    return false;
                }
                if (nodeP.left != null) {
                    pQ.offer(nodeP.left);
                }
                if (nodeP.right != null) {
                    pQ.offer(nodeP.right);
                }
                if ((nodeP.right == null && nodeQ.right != null) || 
                (nodeP.right != null && nodeQ.right == null)) {
                    return false;
                }
                if (nodeQ.left != null) {
                    qQ.offer(nodeQ.left);
                }
                if (nodeQ.right != null) {
                    qQ.offer(nodeQ.right);
                }
            }
        }
        if ((pQ.isEmpty() && !qQ.isEmpty()) || (!pQ.isEmpty() && qQ.isEmpty())) return false;
        
        return true;
    }
}
