import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        //InputStreamReader fr = new FileReader("input.in");
        InputStreamReader fr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fr);
        String[] input;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int sum = 0, odd = 0, v;
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            v = Integer.parseInt(input[i]);
            sum += v;
            if (v % 2 == 1) odd++;
        }
        if (sum % 2 == 1) {
            System.out.println("First");
        } else if (odd == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
