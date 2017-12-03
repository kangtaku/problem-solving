class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, i, j;
        int[][] d = new int[3][n];
        int[] sum = new int[n + 1];
        int[][] store = new int[3][n];
        int[] ans = new int[3];
        for (i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (i = k - 1; i < n; i++) {
            d[0][i] = sum[i + 1] - sum[i - k + 1];
            store[0][i] = i - k + 1;
        }

        for (i = 1; i < 3; i++) {
            int start = (i + 1) * k;
            int max = -1, maxIdx = 0;
            for (j = 0; j < start - k; j++) {
                if (max < d[i - 1][j]) {
                    max = d[i - 1][j];
                    maxIdx = j;
                }
            }
            for (j = 0; j < n; j++) {
                if (max < d[i - 1][j - k]) {
                    max = d[i - 1][j - k];
                    maxIdx = j - k;
                }
                d[i][j] = max + sum[j + 1] - sum[j - k + 1];
                store[i][j] = maxIdx;
            }

        }
        int max = 0, maxIdx = -1;
        for (i = 0; i < n; i++) {
            if (max < d[2][i]) {
                max = d[2][i];
                maxIdx = i;
            }
        }
        
        ans[2] = maxIdx - k + 1;
        ans[1] = store[2][maxIdx] - k + 1;
        ans[0] = store[1][store[2][maxIdx]] - k + 1;
        return ans;
    }
}
