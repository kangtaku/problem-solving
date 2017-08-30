package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int l = in.nextInt();
        int r = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        double k = in.nextInt();
        int a = r;
        int b = x;
        for (int i = l; i <= r; i++) {
            if (i % k == 0 && x <= (i / k) && (i / k) <= y) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
