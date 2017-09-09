package codes;

import FastIO.InputReader;

import java.io.PrintWriter;

public class CHEFPDIG {
  public void solve(int testNumber, InputReader in, PrintWriter out) {
    int i, j, cnt, num;
    boolean[] ans = new boolean[26];
    int[] mp = new int[10];
    while (true) {
      int numChar = in.read();
      if (in.isSpaceChar(numChar)) break;
      num = numChar - '0';
      mp[num] = mp[num] == 2 ? 2 : (mp[num] + 1);
      cnt = 0;
      for (i = 6; i <= 9; i++) {
        for (j = 0; j < 10; j++) {
          if (i == 6 && j < 5) continue;
          if (i == 9 && j == 1) break;

          if ((i == j && mp[i] == 2) || (i != j && mp[i] > 0 && mp[j] > 0)) {
            ans[(i * 10 + j) - 'A'] = true;
          }
        }
      }

      if (cnt == 26) break;
    }

    for (i = 0; i < 26; i++) {
      if (!ans[i]) continue;
      out.print((char) (i + 'A'));
    }
    out.println();
  }
}
