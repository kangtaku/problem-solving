package codes;

import com.sun.org.apache.xpath.internal.operations.Bool;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String word = in.next();
        int startIdx = 0, count = 0, j, consonants = 0;
        Map<Character, Boolean> mp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (isMoeum(word.charAt(i))) {
                out.print(word.charAt(i));
                count = 0;
                continue;
            } else {
                count++;
                if (count == 3) {
                    if (word.charAt(i - 2) == word.charAt(i - 1)
                            && word.charAt(i - 1) == word.charAt(i)) {
                        count-=1;
                    } else {
                        count = 1;
                        out.print(" ");
                    }
                }
                out.print(word.charAt(i));
            }
        }
    }

    public int toI(char c) {
        return c - 'a';
    }

    public boolean isMoeum(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
