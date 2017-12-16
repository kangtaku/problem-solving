class Solution {
public:
    bool makesquare(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % 4 != 0 || sum == 0) {
            return false;
        }
        vector<int> s(4, 0);
        sort(nums.begin(), nums.end());
        return solution(nums, s, 0, sum / 4);
    }
    
    bool solution(vector<int>& nums, vector<int>& l, int idx, int limit) {
        if (idx == nums.size() && l[0] != 0 && l[0] == l[1] && l[1] == l[2] && l[2] == l[3]) {
            return true;
        } else if (idx == nums.size()) {
            return false;
        }
        bool ans = false;
        for (int i = 0; i < 4; i++) {
            if (nums[idx] + l[i] > limit) {
                if (nums[idx] != limit) {
                    return false;
                }
                continue;
            } else {
                l[i] += nums[idx];
                ans |= solution(nums, l, idx + 1, limit);
                if (ans == true) return true;
                l[i] -= nums[idx];
            }
        }
        return ans;
    }
};
