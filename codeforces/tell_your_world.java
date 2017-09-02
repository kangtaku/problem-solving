package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TaskB {
    int[] points;
    int[] used;
    int n;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        int i, j;
        int secondLine = -1, firstLine;
        boolean ans = false;
        points = new int[n];
        used = new int[n];
        for (i = 0; i < n; i++) {
            points[i] = in.nextInt();
        }
        used[0] = 1;/*
        secondLine = findOtherLine(1, 0);
        if (secondLine + 1 == n) {
            out.println("Yes");
            return;
        }*/
        for (i = 0; i < n; i++) {
            used[i] = 1;
            if (i == 0) {
                double firstLean = leanValue(1, points[1], 2, points[2]);
                firstLine = findLine(2, firstLean) + 1;
                if (leanValue(0, points[0], 1, points[1]) != firstLean && firstLine == n - 1) {
                    ans = true;
                    break;
                }
            } else {
                double firstLean = leanValue(0, points[0], i, points[i]);
                firstLine = findLine(i, firstLean) + 1;
                if (firstLine == n) {
                    break;
                }
                secondLine = -1;
                for (j = 1; j < n; j++) {
                    if (used[j] == 0 && secondLine == -1) {
                        secondLine = findOtherLine(j, firstLean);
                    }
                    used[j] = 0;
                }
                if (firstLine + secondLine == n) {
                    ans = true;
                    break;
                }
            }
        }
        if (ans) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }

    public int findOtherLine(int x, double lean) {
        int ans = 1;
        for (int i = x + 1; i < n; i++) {
            if (used[i] == 0 && leanValue(x, points[x], i, points[i]) == lean) {
                ans += findOtherLine(i, lean);
                break;
            }
        }
        return ans;
    }

    public int findLine(int x, double lean) {
        int ans = 1;
        for (int i = x + 1; i < n; i++) {
            if (leanValue(x, points[x], i, points[i]) == lean) {
                used[i] = 1;
                ans += findLine(i, lean);
                break;
            }
        }
        return ans;
    }

    public double leanValue(int x1, int y1, int x2, int y2) {
        if (x1 == x2) return 0;
        return (double)(y2 - y1)/(x2 - x1);
    }
}
