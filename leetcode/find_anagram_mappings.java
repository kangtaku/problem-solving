class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = A.length, m = B.length;
        for (int i = 0; i < m; i++) {
            mp.put(B[i], i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mp.get(A[i]);
        }
        return ans;
    }
}
