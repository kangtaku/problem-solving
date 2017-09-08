package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class CHEFSUM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int i, num, sum = 0, ans = Integer.MAX_VALUE, ansIdx = 0;
        for (i = 0; i < n; i++) {
            num = in.nextInt();
            if (ans > num) {
                ans = num;
                ansIdx = i;
            }

        }
        out.println(ansIdx + 1);
    }
}
