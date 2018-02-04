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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[]{null, null};
        if (root.left == null && root.right == null) {
            return new TreeNode[]{null, root};
        }
        TreeNode d = findV(root, V);
        if (d != null) {
            d.right = null;
        }
        
        return new TreeNode[]{root, d};
    }
    
    public TreeNode findV(TreeNode root, int V) {
        
        if (root.left != null) {
            if (root.left.val <= V) {
                TreeNode t = root.left;
                root.left = root.left.right;
                return t;
            }
            return findV(root.left,V);
        }
        if (root.right != null) {
            if (root.right.val <= V) {
                TreeNode t = root.right;
                root.right = root.right.right;
                return t;
            }
            return findV(root.right,V);
        }
        return null;
    }
}
