class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> st = new HashSet<>();
        int ans = 0;
        for (char c : J.toCharArray()) st.add(c);
        for (char c : S.toCharArray()) {
            if (st.contains(c)) ans++;
        }
        return ans;
    }
}
