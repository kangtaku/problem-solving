package codes;



import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int i;
        int[] nums = new int[n];
        for (i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        if (nums[0] % 2 == 0 || nums[n - 1] % 2 == 0) {
            out.println("No");
            return;
        }
        boolean ans = false;
        int idx = 0, group = 0;
        while (idx < n) {
            if (nums[idx] % 2 == 1) {
                if (idx == n - 1 || (idx < n - 1 && nums[idx + 1] % 2 == 1)) {
                    idx++;
                    group++;
                } else {
                    idx += 2;
                }
            } else {
                idx += 2;
            }
        }

        if (idx == n && group % 2 == 1) {
            ans = true;
        }
        if (ans) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}