package leetcode;

import java.util.Arrays;
//can change?
public class StrangePrinter {
  int[][][] d;
  int n;

  public int strangePrinter(String s) {
    n = s.length();
    d = new int[n + 1][n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        Arrays.fill(d[i][j], Integer.MAX_VALUE);
      }
    }
    return solution(s, 0, n - 1, 0);
  }

  public int solution(String s, int left, int right, int k) {
    if (d[left][right][k] != 0) {
      return d[left][right][k];
    }
    if (left == right) {
      return 1;
    }

    int ret = 0, i, startIdx = left;
    while (startIdx < right && s.charAt(startIdx) == s.charAt(startIdx + 1)) startIdx++;

    for (i = startIdx + 1; i <= right; i++) {
      if (s.charAt(left) == s.charAt(i) &&) {
      }
    }

    return ret;
  }
}