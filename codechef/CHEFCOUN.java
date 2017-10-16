package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class CHEFCOUN {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt(), i;
        long MOD = (long) Math.pow(2, 32);
        int ele = (int)Math.round((double)MOD / n);
        long sum = 0;
        for (i = 0; i < n - 3; i++) {
            sum += ele;
            out.print(ele + " ");
        }
        int last = (int)(MOD - sum - 100) / 2;
        out.print(last  + " " + last + " 1");
        out.println();
    }
}
