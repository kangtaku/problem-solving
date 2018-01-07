class Solution {
    public String boldWords(String[] words, String S) {
        int i, j, n = S.length(), m = words.length, k;
        int[] ck = new int[n];
        char[] changed = String.valueOf(S).toCharArray();
        for (String word:words){
            for (i = 0;i<n-word.length()+1;i++){
                boolean isOkay=true;
                for(j=0;j<word.length();j++){
                    if(word.charAt(j)!=S.charAt(i+j)){
                        isOkay=false;
                        break;
                    }
                }
                if(isOkay){
                    for(j=0;j<word.length();j++){
                        changed[i+j]='@';
                    }
                }
            }
        }
        String ans="";
        boolean isBold=false;
        for(i=0;i<n;i++){
            if(changed[i]=='@'&&!isBold){
                ans+="<b>";
                isBold=true;
            }else if(changed[i]!='@'&&isBold){
                ans+="</b>";
                isBold=false;
            }
            ans+=S.charAt(i);
        }
        if(isBold){
            ans+="</b>";
        }
        return ans;
    }
}
