package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class QUANTIZE {
    int n, s;
    int[] sum, nums;
    int[][] cache;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        s = in.readInt();
        int i;
        nums = new int[n];
        sum = new int[n + 1];
        cache = new int[n + 1][s + 1];
        Arrays.fill(cache[0], -1);
        for (i = 0; i < n; i++) {
            Arrays.fill(cache[i + 1], -1);
            nums[i] = in.readInt();
        }
        Arrays.sort(nums);
        sum[0] = 0;
        for (i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        out.println(solution(0, 0));
    }

    public int getAvg(int from, int to) {
        int rangeSum;
        if (from == 0) {
            rangeSum = sum[to + 1];
        } else {
            rangeSum = sum[to + 1] - sum[from];
        }
        int cnt = to - from + 1;
        int avg = Math.round((float)rangeSum / cnt);
        int ans = 0;
        for (int i = from; i <= to; i++) {
            ans += (nums[i] - avg) * (nums[i] - avg);
        }
        return ans;
    }

    public int solution(int from, int count) {
        if (from == n) return 0;
        if (count == s) return 99999999;
        if (cache[from][count] != -1) {
            return cache[from][count];
        }
        int min = 99999999;
        for (int to = from + 1; to <= n; to++) {
            min = Math.min(min, getAvg(from, to - 1) + solution(to, count + 1));
        }

        cache[from][count] = min;
        return min;
    }
}
