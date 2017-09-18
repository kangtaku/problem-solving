package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        String strN = String.valueOf(n);
        int k = in.readInt(), i;
        int count2 = 0, count5 = 0;
        int tempn = n;
        while (tempn % 5 == 0) {
            tempn /= 5;
            count5++;
        }
        tempn = n;
        while (tempn % 2 == 0) {
            tempn /= 2;
            count2++;
        }
        long ans = n;
        int countMin = Math.min(count2, count5);
        while (countMin < k) {
            if (count2 > count5) {
                count5++;
                ans *= 5;
            } else if (count2 < count5) {
                count2++;
                ans *= 2;
            } else {
                count2++;
                count5++;
                ans *= 10;
            }
            countMin = Math.min(count2, count5);
        }
        out.println(ans);
    }
}
