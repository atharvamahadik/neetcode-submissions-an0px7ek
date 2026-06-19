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
    public int goodNodes(TreeNode root) {
        return traverse(root, root.val);
    }

    private int traverse(TreeNode node, int maxSoFar) {
        if(node==null) {
            return 0;
        }
        int currentScore = 0;
        if(node.val >= maxSoFar) {
            currentScore+=1;
        }
        int newMax = Math.max(node.val,maxSoFar);
        int leftScore = traverse(node.left, newMax);
        int rightScore = traverse(node.right, newMax);
        return currentScore + leftScore + rightScore;
    }
}
