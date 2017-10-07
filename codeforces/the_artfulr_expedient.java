package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        int i, j;
        int[] karen = new int[n];
        int[] koyomi = new int[n];
        for (i = 0; i < n; i++) {
            karen[i] = in.readInt();
        }
        for (i = 0; i < n; i++) {
            koyomi[i] = in.readInt();
        }
        int c1 = countDupli(karen);
        int c2 = countDupli(koyomi);
        if (c1 % 2 == 0) {
            out.println("Karen");
        } else if (c2 % 2 == 0) {
            out.println("Koyomi");
        }
    }

    public int countDupli(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int i, j, n = arr.length, v, a, ans = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                v = arr[i] ^ arr[j];
                int c = count.getOrDefault(v, 0);
                if (c % 2 == 1) ans += (c + 1);
                else if (c != 0 && c % 2 == 0){
                    ans -= c;
                }
                count.put(v, c + 1);
            }
        }
        return ans;
    }
}
