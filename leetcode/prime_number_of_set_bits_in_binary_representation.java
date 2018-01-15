class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> st=new HashSet<>();
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29,31};
        int ans=0;
        for(int prime:primes)st.add(prime);
        for(;L<=R;L++){
            int count=Integer.bitCount(L);
            if(st.contains(count)){
                ans++;
            }
        }
        return ans;
    }
}
