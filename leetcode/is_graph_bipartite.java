class Solution {
    int[] used, d;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, i, j;
        d = new int[n];
        for (i = 0; i < n; i++) {
            int[] g = graph[i];
            int t=d[i] == 0 ? 0 : d[i];
            for(j=0;j<g.length;j++){
                int x = g[j];
                if(d[x] != 0 && d[i] != 0 && d[x] == d[i]){
                    return false;
                }
                if (t != 0 && d[x] != 0) {
                    t = d[x];
                }
            }
            if(t != 0 && d[i] != 0&&d[i] == t){
                return false;
            }
            if (t == 0) t = 1;
            if (d[i] == 0) d[i] = jj(t);
            for (j=0;j<g.length;j++){
                int x= g[j];
                d[x]=t;
            }
        }
        return true;
    }
    
    
    public int jj(int t) {
        if(t==1)return 2;
        else return 1;
    }
}
