package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PACKING {
    int n, k;
    Item[] items;
    int[][] cache;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        k = in.readInt();
        cache = new int[n + 1][k + 1];
        int i;
        items = new Item[n];
        for (i = 0; i < n; i++) {
            items[i] = new Item(in.readToken(), in.readInt(), in.readInt());
        }

        for (i = 0; i <= n; i++) {
            Arrays.fill(cache[i], -1);
        }

        int ans = solve(0, 0);
        ArrayList<Item> anss = new ArrayList<>();
        getAns(0, 0, anss);
        out.println(ans + " " + anss.size());
        for (Item item : anss) {
            out.println(item.name);
        }
    }

    public void getAns(int capacity, int idx, ArrayList<Item> ans) {
        if (idx == n) return;
        if (solve(idx, capacity) == solve(idx + 1, capacity)) {
            getAns(capacity, idx + 1, ans);
        } else {
            ans.add(items[idx]);
            getAns(capacity + items[idx].size, idx + 1, ans);
        }
    }

    public  int solve(int idx, int used) {
        if (idx == n) return 0;
        if (cache[idx][used] != -1) {
            return cache[idx][used];
        }

        int res = solve(idx + 1, used);

        if (used + items[idx].size <= k) {
            res = Math.max(res, solve(idx + 1, used + items[idx].size) + items[idx].score);
        }

        cache[idx][used] = res;
        return res;
    }

    public class Item {
        String name;
        int size;
        int score;

        public Item(String name, int size, int score) {
            this.name = name;
            this.size = size;
            this.score = score;
        }
    }
}

