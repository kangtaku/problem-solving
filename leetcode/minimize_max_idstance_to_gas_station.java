class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int n=stations.length,i,j;
        Arrays.sort(stations);
        PriorityQueue<Double> pq=new PriorityQueue<>();
        double lo=0,hi=99999999;
        while(hi-lo>0.0000001){
            double mid=(hi+lo)/2;
            int need = howNeed(stations, mid);
            if (need > K) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    
    public int howNeed(int[] stations, double d) {
        int cnt = 0,i,n=stations.length;
        for(i=0;i<n-1;i++){
            int diff = stations[i + 1] - stations[i];
            cnt += (diff/d);
        }
        return cnt;
    }
}
