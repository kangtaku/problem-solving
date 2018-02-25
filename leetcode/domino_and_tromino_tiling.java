class Solution {
    public int numTilings(int N) {
        long[] d = new long[1001];
        long[] d2= new long[1001];
        long MOD = 1000000007;
        d2[0]=0;
        d2[1]=1;
        d2[2]=2;
        d[0]=1;
        d[1]=1;
        d[2]=2;
        for(int i=3;i<=N;i++){
            d2[i]=(d[i-1])+(d2[i-1])%MOD;
            d[i]=(d[i-2]+d[i-1]+(d2[i-2]*2))%MOD;
            
        }
        return (int)d[N];
    }
}
