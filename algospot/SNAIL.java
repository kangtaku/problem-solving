package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class SNAIL {
    int n, m;
    double[][] cache;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        m = in.readInt();
        cache = new double[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(cache[i], -1d);
        }
        double ans = (double) Math.round(snail(0, 0) * 1000000000d) / 1000000000d;
        DecimalFormat form = new DecimalFormat("0.0000000000");

        out.println(form.format(ans));
    }

    public double snail(int locate, int days) {
        if (locate >= n) return 1;
        if (days == m) {
            return locate >= n ? 1 : 0;
        }
        if (cache[locate][days] != -1) {
            return cache[locate][days];
        }
        double res = (0.25 * snail(locate + 1, days + 1)) +
                (0.75 * snail(locate + 2, days + 1));
        cache[locate][days] = res;
        return res;
    }
}

