class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        int ans = 0, score, score2;
        for (String op : ops) {
            if (op.equals("C")) {
                score = st.peek();
                st.pop();
                ans -= score;
            } else if (op.equals("D")) {
                score = st.peek();
                ans += score * 2;
                st.push(score * 2);
            } else if (op.equals("+")) {
                score = st.peek();
                st.pop();
                score2 = st.peek();
                st.push(score);
                ans += (score + score2);
                st.push(score + score2);
            } else {
                score = Integer.valueOf(op);
                ans += score;
                st.push(score);
            }
        }
        return ans;
    }
}
