class Solution {
    int k, ans;
    int[][] g;
    int[] v;
    int n;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        k = K;
        g = new int[n][n];
        v = new int[n];
        int i, j;
        this.n = n;
        for (int[] f : flights) {
            g[f[0]][f[1]]=f[2];
        }
        ans = Integer.MAX_VALUE;
        dfs(src, dst, 0, 0);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    
    public void dfs(int src, int dst, int depth, int now) {
        if (depth > k + 1) return;
        if (ans < now) return;
        if (src == dst) {
            if (ans > now) {
                ans = now;
            }
            return;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (src != i && v[i] == 0 && g[src][i] != 0) {
                v[i] = 1;
                dfs(i, dst, depth + 1, now + g[src][i]);
                v[i] = 0;
            }
        }
    }
}
