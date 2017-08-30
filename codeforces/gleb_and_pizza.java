package codes;

import FastIO.InputReader;
import FastIO.Maths;

import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int r = in.nextInt();
        int d = in.nextInt();
        int n = in.nextInt();
        int i, ans = 0, x, y, z;
        for (i = 0; i < n; i++) {

            x = in.nextInt();
            y = in.nextInt();
            z = in.nextInt();
            if (isIn(x, y, z, r, d)) {
                ans++;
            }
        }
        out.println(ans);
    }

    public boolean isIn(int xi, int yi, int ri, int r, int d) {
        double dis = Maths.distance(xi, yi, 0, 0);
        if (dis - ri >= r - d && dis + ri <= r) {
            return true;
        }
        return false;
    }
}
