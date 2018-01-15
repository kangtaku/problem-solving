class Solution {
    public List<Integer> partitionLabels(String S) {
        int i,j,n=S.length();
        char[] cs=S.toCharArray();
        int[][] pair=new int[26][2];
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<26;i++){
            pair[i][0]=Integer.MAX_VALUE;
            pair[i][1]=Integer.MIN_VALUE;
        }
        for(char c='a';c<='z';c++){
            for(i=0;i<n;i++){
                if(cs[i]==c){
                    pair[c-'a'][0]=Math.min(pair[c-'a'][0],i);
                    pair[c-'a'][1]=Math.max(pair[c-'a'][1],i);
                }
            }
        }
        Arrays.sort(pair,(x,y)->{
            if(x[0]!=y[0])return x[0]-y[0];
            if(x[1]!=y[1])return y[1]-x[1];
            return 0;
        });
        int start=pair[0][0],end=pair[0][1];
        for(i=0;i<26;i++){
            if(pair[i][0]==Integer.MAX_VALUE)break;
            if(end<pair[i][0]){
                ans.add(end-start+1);
                start=pair[i][0];
                end=pair[i][1];
            }else if(end<pair[i][1]){
                end=pair[i][1];
            }
        }
        ans.add(end-start+1);
        return ans;
    }
}
