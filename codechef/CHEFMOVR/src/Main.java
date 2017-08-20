import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {
    //InputStreamReader fr = new FileReader("input.in");
    InputStreamReader fr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(fr);
    int cases = Integer.parseInt(br.readLine());
    int n, d, i;
    long[] arr;
    long sum;
    String[] input;
    while (cases-- > 0) {
      input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      d = Integer.parseInt(input[1]);
      arr = new long[n];
      sum = 0;
      input = br.readLine().split(" ");
      for (i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(input[i]);
        sum += arr[i];
      }
      System.out.println(chefMovr(sum, arr, d));
    }
  }

  public static long chefMovr(long sum, long[] arr, int d) {
    long ans = 0;
    int i, n = arr.length, avg, j;
    if (sum % n != 0) {
      return -1;
    }
    avg = (int)(sum / n);
    for (i = 0; i < d; i++) {
      for (j = i; j < n - d; j += d) {
        long pairSum = arr[j] + arr[j + d];
        long diff = Math.abs(avg - arr[j]);
        ans += diff;
        arr[j] = avg;
        arr[j + d] = pairSum - avg;
      }
    }
    for (i = 0; i < n; i++) {
      if (arr[i] != avg) {
        return -1;
      }
    }
    return ans;
  }
}
