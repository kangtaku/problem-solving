class Solution {
    public int minSwapsCouples(int[] row) {
        int i,j,n=row.length,ans=0,t;
        Map<Integer,Integer> couple=new HashMap<>();
        for(i=0;i<60;i+=2){
            couple.put(i,i+1);
            couple.put(i+1,i);
        }
        for(i=0;i<n;i+=2){
            int idx=-1,cou=couple.get(row[i]);
            for(j=i+1;j<n;j++){
                if(cou==row[j]){
                    idx=j;
                    break;
                }
            }
            if(idx!=i+1){
                ans++;
                t=row[idx];
                row[idx]=row[i+1];
                row[i+1]=t;
            }
        }
        return ans;
    }
}
