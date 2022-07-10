class Solution {
    public String longestCommonPrefix(String[] strs) {
        int c=0;
        int min=201;
        String str="";
        for(int i=0;i<strs.length;i++){
            int len=strs[i].length();
            if(len<min){
                min=len;
                str=strs[i];
            }
        }
        
        for(int i=0;i<min;i++){
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=str.charAt(i)){
                    return str.substring(0,c);
                }
            }
            c++;
        }
         return str.substring(0,c);

    }
}