class MinStack {
    Stack<Pair> st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        int min = x;
        if (!st.isEmpty()) {
            min = Math.min(x, st.peek().min);
        }
        st.push(new Pair(x, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

class Pair {
    int val, min;
    Pair(int val, int min) {this.val = val; this.min = min;}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
