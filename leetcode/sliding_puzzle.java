class Solution {
    int min;
    public int isOkay(Set<String> st,int[][] b){
        String s="";
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++){
                s+=String.valueOf(b[i][j]);
            }
        if(s.equals("123450")) return 2;
        if(st.contains(s)) return -1;
        st.add(s);
        return 1;
    }
    public int slidingPuzzle(int[][] board) {
        min = Integer.MAX_VALUE;
        int t,i,j;
        Queue<D> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        int x=-1,y=-1;
        for(i=0;i<2;i++){
            for(j=0;j<3;j++){
                if(board[i][j] == 0){
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        if (isOkay(st,board)==2) {
            return 0;
        }
        q.add(new D(board,0,x,y));
        int[][] arr=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            D d=q.poll();
            x=d.x;
            y=d.y;

            for( i=0;i<4;i++){
                if(x+arr[i][0] == -1 ||x+arr[i][0] == 2||y+arr[i][1]==-1||y+arr[i][1]==3){
                    continue;
                }
                int[][] nb = new int[2][3];
                for(int k=0;k<2;k++){
                for(int z=0;z<3;z++){
                    nb[k][z]=d.b[k][z];
                }
                }
                t=nb[x][y];
                nb[x][y]=nb[x+arr[i][0]][y+arr[i][1]];
                nb[x+arr[i][0]][y+arr[i][1]]=t;
                int res=isOkay(st,nb);
                if(res==2) return d.cnt+1;
                if(res==1){
                    q.add(new D(nb,d.cnt+1,x+arr[i][0],y+arr[i][1]));
                }
            }
        }
        return -1;
    }
}
class D{
    int[][] b;
    int cnt,x,y;
    D(int[][] b, int cnt,int x,int y) {this.b=b;this.cnt=cnt;this.x=x;this.y=y;}
}
