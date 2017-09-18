package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt(), m = in.readInt();
        int i, j;
        int flats[][] = new int[m][2];
        for (i = 0; i < m; i++) {
            flats[i][0] = in.readInt();
            flats[i][1] = in.readInt();
        }

        Arrays.sort(flats, Comparator.comparingInt(x -> x[0]));

        if (n == 1) {
            out.print(1);
            return;
        }
        int ans = -1, nowAns = 0;
        for (i = 1; i <= 100; i++) {
            if (isValid(flats, i)) {
                nowAns = n / i;
                if (n % i != 0) {
                    nowAns++;
                }
                if (ans == -1) {
                    ans = nowAns;
                } else if (ans != nowAns) {
                    ans = -1;
                    break;
                }
            }
        }
        out.println(ans);
    }

    public boolean isValid(int[][] flats, int numOfFlats) {
        int i = 1;
        int now = 1;
        int floor = 1;
        int flat = numOfFlats;
        for (i = 0; i < flats.length;) {
            if (floor < flats[i][1]) {
                floor++;
                flat += numOfFlats;
            } else if (floor == flats[i][1]) {
                if (flats[i][0] <= flat && flats[i][0] >= flat - numOfFlats + 1) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
