package codes;

import FastIO.InputReader;
import utils.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class SEACO {
    final int MODULO = 1000000007;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt(), m = in.readInt();
        int i, t, l, r, j;

        Command[] commands = new Command[m];

        for (i = 0; i < m; i++) {
            t = in.readInt();
            l = in.readInt() - 1;
            r = in.readInt() - 1;
            Command command = new Command(t, l, r);
            commands[i] = command;
        }

        int[] cnt = new int[m + 1];
        int[] dcnt = new int[m];

        Arrays.fill(cnt, 1);
        for (i = m - 1; i >= 0; i--) {
            Command command = commands[i];
            cnt[i] = mod(dcnt[i] + cnt[i + 1]);
            if (command.t == 2) {
                dcnt[command.r] = mod(dcnt[command.r] + cnt[i]);
                if (command.l > 0)
                    dcnt[command.l - 1] = mod(dcnt[command.l - 1] - cnt[i]);
            }
        }

        int[] dans = new int[n];
        int[] ans = new int[n + 1];

        for (i = 0; i < m; i++) {
            Command command = commands[i];
            if (command.t == 1) {
                dans[command.r] = mod(dans[command.r] + cnt[i]);
                if (command.l > 0)
                    dans[command.l - 1] = mod(dans[command.l - 1] - cnt[i]);
            }
        }

        for (i = n - 1; i >= 0; i--) {
            ans[i] = mod(ans[i + 1] + dans[i]);
        }

        for (i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }

        out.println();
    }

    int mod(int x) {
        if (x >= MODULO) return x - MODULO;
        else if (x < 0) return x + MODULO;
        return x;
    }

    class Command {
        int t;
        int l;
        int r;

        public Command(int t, int l, int r) {
            this.t = t;
            this.l = l;
            this.r = r;
        }
    }
}
