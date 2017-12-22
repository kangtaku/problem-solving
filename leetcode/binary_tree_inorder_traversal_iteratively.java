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
        Stack<TreeNode> st = new Stack<>();
        TreeNode now = root;
        while (now != null || st.size() > 0) {
            while (now != null) {
                st.push(now);
                now = now.left;
            }
            now = st.pop();
            ans.add(now.val);
            now = now.right;
        }
        return ans;
    }
}
