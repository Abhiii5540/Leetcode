class Solution {
    public String reverseWords(String s) {
        
        s=s.trim();
        String words[]=s.split("\\s+");  
        List<String> l=Arrays.asList(words);
        Collections.reverse(l);
        return String.join(" ", l);
        
       // String words[]=s.split("\\s+");  
       //      StringBuilder sb=new StringBuilder(); 
       //      for (int i = words.length-1; i >=0; i--) {
       //          sb.append(words[i]+" ");
       //      }  
       //  return sb.toString().trim();  
    }
}