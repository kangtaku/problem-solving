class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size(), i, j;
        vector<int> d(n, 0);
        vector<int> count(n, 0);
        for (i = 0; i < n; i++) {
            d[i] = 1;
            count[i] = 1;
            for (j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (d[i] < d[j] + 1) {
                        d[i] = d[j] + 1;
                        count[i] = count[j];
                       // mp[d[i]] = 1;
                    } else if (d[i] == d[j] + 1) {
                        count[i] += count[j];
                       // mp[d[i]]++;
                    }
                }
            }
        }
        int ans = 0, mx = -1;
        for (i = 0; i < n; i++) {
            mx = max(mx, d[i]);
        }
        for (i = 0; i < n; i++) {
            if (d[i] == mx) {
                ans += count[i];
            }
        }

        return ans;
    }
};
