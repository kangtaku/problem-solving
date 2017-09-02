package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        String ans = make(k, 97);
        out.println(ans);
    }

    public String make(int k, int c) {
        StringBuilder ans = new StringBuilder();
        char nowChar = (char) c;
        ans.append(nowChar);
        int count = 0, now = 1, i = 1;
        for (;;) {
            if (count + now <= k) {
                count += now;
            } else if (count == k) {
                break;
            } else {
                int nextK = (k - count);
                ans.append(make(nextK, c + 1));
                break;
            }
            ans.append(nowChar);
            now++;
        }
        return ans.toString();
    }
}
