import java.util.HashSet;
import java.util.Set;

public class DeckOfCards {
    public String IsValid(int n, int[] value, String suit) {
      boolean ans = true;

      int i, j, m = suit.length();
      Set<String> st = new HashSet<>();
      char[] cs = suit.toCharArray();
      for (i =0;i<n;i++){
        String card = String.valueOf(value[i]) + cs[i];
        if (st.contains(card)) {
          ans = false;
          break;
        }
        st.add(card);
      }

      if (ans) {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
              if (cs[i] == cs[j]) continue;
              String card1 = String.valueOf(value[i]) + cs[j];
              String card2 = String.valueOf(value[j]) + cs[i];
              if (!st.contains(card1) || !st.contains(card2)) {
                ans = false;
                break;
              }
            }
            if (!ans) break;
        }
      }
      return ans ? "Perfect" : "Not perfect";
    }
  }
