import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  static Map<String, Integer> cache;
  public static void main(String[] args) throws Exception {
    InputStreamReader fr = new InputStreamReader(System.in);
    //InputStreamReader fr = new FileReader("input.in");
    BufferedReader br = new BufferedReader(fr);

    int cases = Integer.parseInt(br.readLine());
    int i;
    boolean ans;
    String s;
    String t;
    int[] sCnt = new int[26];
    int[] tCnt = new int[26];
    while (cases-- > 0) {
      cache = new HashMap<String, Integer>();
      for (i = 0; i < 26; i++) {
        sCnt[i] = 0;
        tCnt[i] = 0;
      }
      s = br.readLine();
      t = br.readLine();
      for (i = 0; i < s.length(); i++) {
        sCnt[s.charAt(i) - 'a']++;
        tCnt[t.charAt(i) - 'a']++;
      }
      ans = canWin(sCnt, tCnt);
      if (ans) {
        System.out.println("A");
      } else {
        System.out.println("B");
      }
    }
  }

  public static boolean canWin(int[] s, int[] t) {
    int i;
    int a = 0, b = 0;
    for (i = 0; i < 26; i++) {
      if (s[i] > 1 && t[i] == 0) {
        return true;
      }
      if (s[i] > 0 && t[i] == 0) {
        a++;
      }
      if (s[i] == 0 && t[i] > 0) {
        b++;
      }
    }

    if (a > 0 && b == 0) {
      return true;
    }
    return false;
  }
}