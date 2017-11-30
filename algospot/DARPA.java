package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class DARPA {
    double[] cameras;
    int n, m;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        m = in.readInt();
        cameras = new double[m];
        int i;
        for (i = 0; i < m; i++) {
            cameras[i] = in.readDouble();
        }

        double lo = 0, hi = 240.0;
        while (hi - lo > 0.00000001) {
            double mid = (lo + hi) / 2.0;
            if (canInstall(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        lo = Math.round(lo * 100) / 100d;
        out.printf("%.2f", lo);
        out.println();
    }

    public boolean canInstall(double dist) {
        int i, count;
        double now = cameras[0];
        count = 1;
        for (i = 1; i < m; i++) {
            if (now + dist <= cameras[i]) {
                now = cameras[i];
                count++;
                if (count == n) return true;
            }
        }
        return false;
    }
}

