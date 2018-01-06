/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    public int depth(TreeNode root) {
        if(root==null)return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
