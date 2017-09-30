package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class C00K0FF {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        int chk = 0;
        boolean ans = false;
        String s;
        for (int i = 0; i < n; i++) {
            s = in.next();
            if (chk == 31) continue;
            if (s.equals("cakewalk")) chk |= 1;
            if (s.equals("simple")) chk |= 2;
            if (s.equals("easy")) chk |= 4;
            if (s.equals("easy-medium") || s.equals("medium")) chk |= 8;
            if (s.equals("medium-hard") || s.equals("hard")) chk |= 16;
            if (chk == 31) {
                ans = true;
            }
        }
        if (ans) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
