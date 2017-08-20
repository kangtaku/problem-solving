import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Solution solution = new Solution();

    System.out.println(solution.isMatch("", ".*"));

    //System.out.println(solution.cheapestJump("aa", ".*"));

  }




  public static class Solution {
    public boolean isMatch(String s, String p) {
      int n = s.length(), m = p.length(), i, j;
      s = ' ' + s;
      p = ' ' + p;
      boolean[][] d = new boolean[n + 1][m + 1];
      d[0][0] = true;
      for (i = 1; i <= m; i++) {
        d[0][i] = p.charAt(i) == '*' && d[0][i - 2];
      }

      for (i = 1; i <= n; i++) {
        for (j = 1; j <= m; j++) {
          if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
            d[i][j] = d[i - 1][j - 1];
          }
          if (p.charAt(j) == '*') {
            if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
              d[i][j] = d[i][j - 2];
            } else if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
              d[i][j] = d[i][j - 1] || d[i - 1][j] || d[i][j - 2];
            }
          }
        }
      }
      return d[n][m];
    }
  }
}