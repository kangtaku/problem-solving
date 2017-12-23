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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(ans, root);
        return ans;
    }
    
    public void solve(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        ans.add(root.val);
        solve(ans, root.left);
        solve(ans, root.right);
    }
}
