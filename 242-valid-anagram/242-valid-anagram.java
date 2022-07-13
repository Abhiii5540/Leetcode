class Solution {
    public boolean isAnagram(String s, String t) {
      char s1[]=s.toCharArray();
      char s2[]=t.toCharArray();
      Arrays.sort(s1);
      Arrays.sort(s2);
        String x=String.valueOf(s1);
                String y=String.valueOf(s2);

      if(x.equals(y)){
          return true;
      }
      return false;  
    }
}