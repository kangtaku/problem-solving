class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        solve(ans, nums, new boolean[n], new ArrayList<>());
        return ans;
    }
    
    public void solve(List<List<Integer>> ans, int[] nums, boolean[] used,List<Integer> permu) {
        int n = nums.length, i;
        if (permu.size() ==n) {
            ans.add(new ArrayList<>(permu));
            return;
        }
        for (i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                permu.add(nums[i]);
                solve(ans,nums,used,permu);
                permu.remove(permu.size() - 1);
                used[i] = false;
            }
        }
    }
}
