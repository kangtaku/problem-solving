class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans=1,n=points.length;
        if(n==0)return 0;
        Arrays.sort(points,(x,y)->{
            if(x[1]!=y[1])return x[1]-y[1];
            else if(x[0]!=y[0])return x[0]-y[0];
            return 0;
        });
        int end=points[0][1];
        for(int i=1;i<n;i++){
            int[] point=points[i];
            if(point[0]<=end&&end<=point[1]){
                continue;
            }else if(end<=point[0]){
                end=point[1];
                ans++;
            }
        }
        return ans;
    }
}
