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
    public TreeNode sortedArrayToBST(int[] numås) {
        return makeTree(0, nums.length - 1, nums);
    }
    public TreeNode makeTree(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(left, mid - 1, nums);
        root.right = makeTree(mid + 1, right, nums);
        return root;
    }
}
