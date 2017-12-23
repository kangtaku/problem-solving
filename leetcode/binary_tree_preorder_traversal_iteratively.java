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
        Stack<TreeNode> st = new Stack<>();
        
        while (root != null || st.size() > 0) {
            while (root != null) {
                st.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return ans;
    }
}
