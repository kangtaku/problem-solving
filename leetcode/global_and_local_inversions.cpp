class Solution {
public:
    bool isIdealPermutation(vector<int>& A) {
        int global = 0, local = 0, i, j, n = A.size();
        set<int> st;
        for (i = 0; i < n-1; i++) local += (A[i] > A[i + 1]) ? 1 : 0;
        st.insert(A[0]);
        for (i = 1; i < n; i++) {
            auto idx = st.lower_bound(A[i]);
            global += distance(idx, st.end());
            // cout << distance(idx, st.end()) << endl;
            st.insert(A[i]);
        } 
        cout << global<< " " << local;
        return global == local;
    }
};
