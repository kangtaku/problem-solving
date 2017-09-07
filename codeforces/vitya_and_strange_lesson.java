package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskD {
    final static int bitSize = 20;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Trie numTrie = new Trie();
        Map<Integer, Integer> cache = new HashMap<>();
        int n = in.nextInt(), m = in.nextInt(), i, query;
        for (i = 0; i < n; i++) {
            int num = in.nextInt();
            if (cache.containsKey(num)) continue;
            cache.put(num, 1);
            numTrie.add(num);
        }
        int nowQuery = 0;
        for (i = 0; i < m; i++) {
            query = in.nextInt();
            nowQuery ^= query;
            out.println(mex(numTrie, nowQuery));
        }
    }

    private int saveSize(Trie trie) {
        if (trie == null) return 0;
        return trie.size;
    }

    private int mex(Trie trie, int query) {
        int ans = 0;
        for (int i = bitSize; i >= 0; i--) {
            if (trie == null) return ans;
            if (trie.left == null && trie.right == null) return ans;

            if ((query & (1 << i)) == 0) {
                if (saveSize(trie.left) != (1 << i)) {
                    trie = trie.left;
                } else {
                    ans += (1 << i);
                    trie = trie.right;
                }
            } else {
                if (saveSize(trie.right) != (1 << i )) {
                    trie = trie.right;
                } else {
                    ans += (1 << i);
                    trie = trie.left;
                }
            }
        }
        return ans;
    }

    public class Trie {
        Trie left, right;
        int size;
        public Trie() {}
        public void add(int num) {
            Trie nowTrie = this;
            this.size++;
            for (int i = bitSize; i >= 0; i--) {
                if ((num & (1 << i)) == 0) {
                    if (nowTrie.left == null) {
                        nowTrie.left = new Trie();
                    }
                    nowTrie = nowTrie.left;
                } else {
                    if (nowTrie.right == null) {
                        nowTrie.right = new Trie();
                    }
                    nowTrie = nowTrie.right;
                }
                nowTrie.size++;
            }
        }
    }
}