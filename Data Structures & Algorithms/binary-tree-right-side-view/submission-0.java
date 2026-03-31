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
        List<Integer> list = new LinkedList<Integer>();
        rightView(root, list, 0);
        return list;
    }

    private void rightView(TreeNode node, List<Integer> l, int level) {
        if(node == null) return;
        if(level == l.size()) l.add(node.val);
        rightView(node.right,l, level + 1);
        rightView(node.left,l, level + 1);
    }
}
