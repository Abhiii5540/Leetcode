class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int max=0;
        int hashset[]=new int[128];
        while(j<s.length()){
            char c=s.charAt(j);
            hashset[c]++;
        
        while(hashset[c]>1){
            char x=s.charAt(i);
            hashset[x]--;
            i++;
        }
        max=Math.max(max,j-i+1);
        j++;
     }
    return max;
  }
}