package codes;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import FastIO.InputReader;

public class search_1786 {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int MOD1 = 1000000021;
        int MOD2 = 1000000033;
        long Q = 31;
        int[] ans = new int[1000001];
        int i;
        String T = in.readLine();
        String P = in.readLine();

        int prev1 = 1;
        int prev2 = 1;
        int n = T.length(), m = P.length();
        if (T.charAt(n - 1) == 10) n--;
        if (P.charAt(m - 1) == 10) m--;
        int idx = 0;
        int ph1 = 0, th1 = 0;
        int ph2 = 0, th2 = 0;
        if (m > n) {
            out.println("0");
            return;
        }
        for (i = 0; i < m; i++) {
            ph1 = (int)((Q * ph1 + P.charAt(i)) % MOD1);
            ph2 = (int)((Q * ph2 + P.charAt(i)) % MOD2);
            th1 = (int)((Q * th1 + T.charAt(i)) % MOD1);
            th2 = (int)((Q * th2 + T.charAt(i)) % MOD2);
            prev1 = (int)((Q * prev1) % MOD1);
            prev2 = (int)((Q * prev2) % MOD2);
        }

        //out.println(ph1 +","+th1+","+prev1 + ", " + prev2);

        if (ph1 == th1 && ph2 == th2) {
            ans[idx++] = 1;
        }

        for (i = m; i < n; i++) {
            th1 = (int)((Q * th1 + T.charAt(i) - 1L * T.charAt(i - m) * prev1 % MOD1 + MOD1) % MOD1);
            th2 = (int)((Q * th2 + T.charAt(i) - 1L * T.charAt(i - m) * prev2 % MOD2 + MOD2) % MOD2);
            if (ph1 == th1 && ph2 == th2) {
                ans[idx++] = i - m + 2;
            }
        }
        out.println(idx);
        for (i = 0; i < idx; i++) {
            out.println(ans[i]);
        }
    }
}

