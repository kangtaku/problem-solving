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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        make(ans, root);
        return ans;
    }
    
    public void make(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        make(ans, root.left);
        ans.add(root.val);
        make(ans, root.right);
    }
}
