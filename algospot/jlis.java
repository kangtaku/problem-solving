package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class JLIS {
    int[] arr1, arr2;
    int[][] cache;
    int n, m;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int i;
        n = in.readInt();
        m = in.readInt();
        cache = new int[n + 1][m + 1];
        arr1 = new int[n];
        arr2 = new int[m];
        for (i = 0; i < n; i++) {
            arr1[i] = in.readInt();
            //Arrays.fill(cache[i], -1);
        }
        for (i = 0; i < m; i++) {
            arr2[i] = in.readInt();
        }
        out.println(jlis(-1, -1));
    }

    public int jlis(int x, int y) {
        int ret = cache[x + 1][y + 1];
        if (ret != 0) {
            return ret;
        }

        long a = x == -1 ? Integer.MIN_VALUE : arr1[x];
        long b = y == -1 ? Integer.MIN_VALUE : arr2[y];
        long cur = Math.max(a, b);

        for (int i = x + 1; i < n; i++) {
            if (cur < arr1[i]) {
                ret = Math.max(ret, jlis(i, y) + 1);
            }
        }

        for (int i = y + 1; i < m; i++) {
            if (cur < arr2[i]) {
                ret = Math.max(ret, jlis(x, i) + 1);
            }
        }

        cache[x + 1][y + 1] = ret;
        return ret;
    }
}

