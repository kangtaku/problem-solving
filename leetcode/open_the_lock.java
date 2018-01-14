class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> st=new HashSet<>();
        Set<String> chk=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(String d:deadends)st.add(d);
        q.add(new Pair(0,"0000"));
        chk.add("0000");
        while(!q.isEmpty()){
            Pair head=q.poll();
            if(st.contains(head.str))continue;
            if(head.str.equals(target))return head.cnt;
            for(int i=0;i<4;i++){
                char c=head.str.charAt(i);
                c++;
                if(c>'9')c='0';
                String newStr=head.str.substring(0,i)+c+head.str.substring(i+1);
                if(!chk.contains(newStr)){
                    chk.add(newStr);
                    q.add(new Pair(head.cnt+1,newStr));
                }
                c=head.str.charAt(i);
                c--;
                if(c<'0')c='9';
                String newStr2=head.str.substring(0,i)+c+head.str.substring(i+1);
                if(!chk.contains(newStr2)){
                    chk.add(newStr2);
                    q.add(new Pair(head.cnt+1,newStr2));
                }
            }
        }
        return -1;
    }
}
class Pair{
    int cnt;
    String str;
    Pair(int cnt,String str){this.cnt=cnt;this.str=str;}
}
