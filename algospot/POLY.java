package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class POLY {
    final static int MOD = 10000000;
    int[][] cache;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        int ans = 0;
        cache = new int[n + 1][n + 1];
        for (int first = 1; first <= n; first++) {
            ans = (ans + poly(n, first)) % MOD;
        }
        out.println(ans);
    }

    private int poly(int n, int first) {
        if (n == first) return 1;
        if (cache[n][first] != 0) return cache[n][first];
        int ret = 0;

        for (int second = 1; second <= n - first; second++) {
            int count = (poly(n - first, second) * (first + second - 1)) % MOD;
            ret = (ret + count) % MOD;
        }

        cache[n][first] = ret;
        return ret;
    }
}
