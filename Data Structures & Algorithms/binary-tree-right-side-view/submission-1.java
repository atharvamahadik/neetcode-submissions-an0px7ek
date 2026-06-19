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
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root, 0);
        return ans;
    }

    private void traverse(List<Integer> ans, TreeNode node, int level) {
        if(node==null) {
            return;
        }
        if(level==ans.size()) {
            ans.add(node.val);
        }
        traverse(ans, node.right, level + 1);
        traverse(ans, node.left, level + 1);
    }
}
