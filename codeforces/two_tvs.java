import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import javafx.util.Pair;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i, j;
        List<Pair<Integer, Integer>> tvs = new ArrayList<>();

        int k, v;
        for (i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            tvs.add(i, new Pair<>(k, v));
        }
        if (n == 2) {
            System.out.print("YES");
            return;
        }
        int first = -1, second = -1;
        boolean isOkay = true;
        tvs.sort((a, b) -> {
            if (a.getKey().compareTo(b.getKey()) != 0) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return a.getValue().compareTo(b.getValue());
            }
        });
        for (i = 0; i < n; i++) {
            if (first < tvs.get(i).getKey()) {
                first = tvs.get(i).getValue();
            } else if (second < tvs.get(i).getKey()) {
                second = tvs.get(i).getValue();
            } else {
                isOkay = false;
                break;
            }
        }
        if (isOkay) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
