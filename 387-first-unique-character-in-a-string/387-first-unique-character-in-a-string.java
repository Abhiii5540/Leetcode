class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            // getOrdeafult means get the value preset at the key , if ot present return 0
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            // if(map.get(s.charAt(i))==null){
            //     map.put(s.charAt(i),i);
            // }
            // else{
            //     int c=map.get(s.charAt(i));
            //     c++;
            //     map.put(s.charAt(i),c);
            // }
        }
        for(int i=0;i<s.length();i++){
             if(map.get(s.charAt(i))==1)
                 return i;
                
        }
        return -1;
    }
}