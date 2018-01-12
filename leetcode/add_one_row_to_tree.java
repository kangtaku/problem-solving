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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode t=new TreeNode(v);
            t.left=root;
            return t;
        }
        insert(root, v, d, 1);
        return root;
    }
    
    public void insert(TreeNode root, int v, int d, int depth) {
        if(root==null)return;
        if(d==depth+1){
            TreeNode t=root.left;
            root.left=new TreeNode(v);
            root.left.left=t;
            
            t=root.right;
            root.right=new TreeNode(v);
            root.right.right=t;
            return;
        }
        insert(root.left,v,d,depth+1);
        insert(root.right,v,d,depth+1);
    }
}
