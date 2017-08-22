import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        InputStreamReader fr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fr);
        String in = br.readLine();
        int[] digits = new int[6];
        int left = 0, right = 0;
        for (int i = 0; i < 6; i++) {
            digits[i] = in.charAt(i) - '0';
            if (i < 3) {
                left += digits[i];
            } else right += digits[i];
        }
        solve(digits, 0, 0, left, right);
        System.out.println(ans);
    }

    public static void solve(int[] digits, int idx, int count, int left, int right) {
        int i, j, temp;
        if (ans <= count) {
            return;
        }
        if (left == right) {
            if (ans > count) {
                ans = count;
            }
            return;
        }
        for (i = idx; i < 6; i++) {
            int[] newDigits = digits.clone();
            for (j = 0; j <= 9; j++) {
                if (newDigits[i] == j) continue;
                if (i < 3) {
                    left -= digits[i];
                    left += j;
                } else {
                    right -= digits[i];
                    right += j;
                }
                newDigits[i] = j;
                solve(newDigits, idx + 1, count + 1, left, right);
                newDigits[i] = digits[i];
                if (i < 3) {
                    left += digits[i];
                    left -= j;
                } else {
                    right += digits[i];
                    right -= j;
                }
            }
        }

    }
}
