import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStreamReader fr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fr);
        int n = Integer.parseInt(br.readLine()), i;
        int[] people = new int[n * 2];
        String[] input = br.readLine().split(" ");
        for (i = 0; i < n * 2; i++) {
            people[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(people);
        for (i = 0; i < n; i++) {
            if (people[i] == people[n * 2 - i - 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
