class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int i, n = nums.size();
        if (n == 0) return 0;
        vector<int> d(n + 1, 0);
        d[0] = 1;
        for (i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                d[i] = d[i - 1] + 1;
            } else {
                d[i] = 1;
            }
        }
        int ans = -1;
        for (i = 0; i < n; i++) {

            ans = max(ans, d[i]);
        }
        return ans;
    }
};
