package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class MINPERM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), i;
        int[] ans = new int[n];
        for (i = 0; i < ((n | 1) ^ 1); i += 2) {
            ans[i] = i + 2;
            ans[i + 1] = i + 1;
        }
        if (n % 2 == 1) {
            ans[n - 1] = ans[n - 2];
            ans[n - 2] = n;
        }
        for (i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }
}
