package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MEX {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt(), k = in.readInt();
        int i, ans = 0;
        int[] arr = new int[n];
        Set<Integer> st = new TreeSet<>();
        for (i = 0; i < n; i++) {
            st.add(in.readInt());
        }

        Iterator<Integer> itr = st.iterator();
        int val = itr.next(), count = 0;
        for (i = 0; i <= 2 * 100000; i++) {
            ans = i;
            if (count < st.size() && i == val) {
                count++;
                if (itr.hasNext()) {
                    val = itr.next();
                }
                continue;
            }

            if (k > 0) {
                k--;
                continue;
            } else {
                break;
            }
        }
        out.println(ans);
    }
}
