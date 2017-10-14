package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class PERFCONT {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt(), p = in.readInt(), i;
        int easy = 0, hard = 0;
        int solveCount;

        for (i = 0; i < n; i++) {
            solveCount = in.readInt();
            if (solveCount <= Math.floor((double)p / 10)) hard++;
            else if (solveCount >= Math.floor((double)p / 2)) easy++;
        }

        //out.println(easy + ", " + hard);

        if (easy * 2 == hard) {
            out.println("yes");
        } else {
            out.println("no");
        }
    }
}
