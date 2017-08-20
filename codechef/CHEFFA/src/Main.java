import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  static int n;
  static int[][][] dp;
  static int[][] cache = new int[101][101];
  static int[] arr;
  static final int M = 1000000007;
  public static void main(String[] args) throws Exception {
    //InputStreamReader fr = new InputStreamReader(System.in);
    InputStreamReader fr = new FileReader("input.in");
    BufferedReader br = new BufferedReader(fr);

    String[] input;
    int cases = Integer.parseInt(br.readLine());
    int i;
    while (cases-- > 0) {
      n = Integer.parseInt(br.readLine());
      dp = new int[201][201][201];
      arr = new int[50];
      input = br.readLine().split(" ");
      for (i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(input[i]);
      }
      System.out.println(solution(0, arr[0], arr[1]));
    }
  }

  static int solution(int idx, int x, int y) {
    if (dp[idx][x][y] != 0) {
      return dp[idx][x][y];
    }

    if (idx == n -1) {
      dp[idx][x][y] = howMany(x, y);
    } else {
      int rng = Math.min(x, y);
      for (int i = 0; i <= rng; i++) {
        dp[idx][x][y] = (dp[idx][x][y] + solution(idx + 1, y - i, i + arr[idx + 2])) % M;
      }
    }

    return dp[idx][x][y];
  }

  static Integer howMany(int x, int y) {
    if (x == 0 || y == 0) {
      return 1;
    }
    int newX = x, newY = y;
    if (newX > newY) {
      newX = newY;
    } else if (newX * 2 < newY) {
      newY = newX * 2;
    }
    if (cache[newX][newY] != 0) {
      return cache[newX][newY];
    }
    int res = 0;
    for (int i = 0; i <= newX; i++) {
      res = (res + howMany(newY - i, i)) % M;
    }
    cache[x][y] = res;
    return res;
  }

  static String toStr(List<Integer> arr, int idx) {
    StringBuilder str = new StringBuilder("");
    for (int i = idx; i < arr.size(); i++) {
      if (i == idx && arr.size() > idx + 1 && arr.get(idx) > arr.get(idx + 1)) {
        str.append(arr.get(idx + 1) + ", ");
      } else {
        str.append(arr.get(i) + ",");
      }
    }
    return str.toString();
  }
}