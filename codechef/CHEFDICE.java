package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CHEFDICE {
    int[] ans;
    int[] a;
    int[] used;
    int n;
    boolean has;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int i;
        n = in.readInt();
        ans = new int[7];
        a = new int[n];
        used = new int[7];
        boolean befor = false;
        int[] chk = new int[7];
        int chkCount = 0;
        for (i = 0; i < n; i++) {
            a[i] = in.readInt();

            if (chk[a[i]] == 0) {
                chkCount++;
                chk[a[i]] = 1;
            }

            if (i > 0 && a[i] == a[i - 1]) {
                befor = true;
            }
        }
        if (chkCount < 4) befor = true;
        if (befor) {
            out.println("-1");
            return;
        }
        Arrays.fill(ans, -1);
        has = false;
        findAns(ans, 1);
        if (has) {
            for (i = 1; i <= 6; i++) {
                out.print(ans[i] + " ");
            }
        } else {
            out.print("-1");
        }
        out.println();
    }

    public void findAns(int[] ans, int idx) {
        if (idx == 7) {
            if (1 == ans[ans[1]] && 2 == ans[ans[2]] && 3 == ans[ans[3]] &&
                    4 == ans[ans[4]] && 5 ==ans[ans[5]] && 6 == ans[ans[6]]) {
                for (int i = 1; i <= 6; i++) {
                    for (int j = 0; j < n; j++) {
                        if (a[j] == i) {
                            if ((j > 0 && a[j - 1] == ans[i]) ||
                                    (j < n - 1 && a[j + 1] == ans[i])) {
                                return;
                            }
                        }
                    }
                }
                has = true;
            } else {
                return;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (used[i] == 0 && i != idx) {
                ans[idx] = i;
                used[i] = 1;
                findAns(ans, idx + 1);
                if (has) {
                    return;
                }
                ans[idx] = -1;
                used[i] = 0;
            }
        }
    }
}
