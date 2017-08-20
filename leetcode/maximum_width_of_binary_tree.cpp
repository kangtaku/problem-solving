/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
    int M = INT_MAX - 1;
public:
    int widthOfBinaryTree(TreeNode* root) {
        unordered_map<int, long long> mp;
        unordered_map<int, long long> minMp;
        solve(mp, minMp, root, 0, 0);
        int depth = 0;
        long long ans = -1;
        while (mp.find(depth) != mp.end()) {
            ans = max(ans, mp[depth] - minMp[depth]);
            depth++;
        }
        return ans + 1;
    }
    
    void solve(unordered_map<int, long long>& mp,unordered_map<int, long long>& minMp, TreeNode* root, int depth, long long width) {
        if (root == NULL) {
            return;
        }
        if (mp.find(depth) == mp.end()) {
            mp[depth] = 0;
            minMp[depth] = INT_MAX;
        }
        mp[depth] = max(mp[depth], width);
        minMp[depth] = min(minMp[depth], width);
        //ans = max(mp[depth] - minMp[depth], ans);
        solve(mp, minMp,root->left, depth + 1, (width * 2 + 1) % M);
        solve(mp, minMp,root->right, depth + 1, (width * 2 + 2) % M);
    }
};