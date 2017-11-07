package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class NUMB3RS {
    int n, d, p;
    int[][] g;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        d = in.readInt();
        p = in.readInt();
        g = new int[n][n];
        int i, j, cnt;
        double t;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                g[i][j] = in.readInt();
            }
        }

        double[][] dp = new double[d + 1][n];
        dp[0][p] = 1;
        for (int day = 1; day <= d; day++) {
            for (i = 0; i < n; i++) {
                if (dp[day - 1][i] != 0) {
                    cnt = 0;
                    for (j = 0; j < n; j++) {
                        if (g[i][j] != 0) {
                            cnt++;
                        }
                    }
                    t = 1d / cnt;
                    for (j = 0; j < n; j++) {
                        if (g[i][j] != 0) {

                            dp[day][j] += dp[day - 1][i] * t;
                        }
                    }
                }
            }
        }

        DecimalFormat form = new DecimalFormat("0.00000000");

        int m = in.readInt(), pl;
        for (i = 0; i < m; i++) {
            pl = in.readInt();
            out.print(form.format(dp[d][pl]) + " ");
        }
        out.println();
    }
}

