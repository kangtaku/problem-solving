import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.in"));

        int cases = Integer.parseInt(br.readLine());
        int n, i;
        int[] rainbows;
        boolean hasOther;
        String[] input = null;
        while (cases-- > 0) {
            n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            rainbows = new int[n];
            hasOther = false;
            for (i = 0; i < n; i++) {
                rainbows[i] = Integer.parseInt(input[i]);
                if (rainbows[i] > 7) {
                    hasOther = true;
                    break;
                }
            }
            if (hasOther) {
                System.out.println("no");
            } else {
                boolean ans = isOkay(n, rainbows);
                System.out.println(ans ? "yes" : "no");
            }
        }
    }

    public static boolean isOkay(int n, int[] rainbows) {
        boolean[] ck = new boolean[11];
        int[] eles = new int[]{1,2,3,4,5,6,7,6,5,4,3,2,1};
        int mx = -1, eIdx = 0, i, j = -1;
        if (rainbows[0] != 1) {
            return false;
        }
        for (i = 0; i < n; i++) {
            if (rainbows[i] != eles[eIdx]) {
                eIdx++;
                if (rainbows[i] != eles[eIdx]) {
                    return false;
                }
            }
        }
        if (eIdx != eles.length - 1) {
            return false;
        }
        i = 0;
        j = n - 1;
        while (i < n && rainbows[i] != 7) i++;
        while (j > 0 && rainbows[j] != 7) j--;
        if (j == 0) return true;
        while (i >= 0 && j < n) {
            if (rainbows[i] != rainbows[j]) {
                return false;
            }
            i--;
            j++;
        }
        return j == n;
    }
}
