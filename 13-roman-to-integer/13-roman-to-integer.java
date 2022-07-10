class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("I",1);
         map.put("V",5);
         map.put("X",10);
         map.put("L",50);
         map.put("C",100);
         map.put("D",500);
         map.put("M",1000);
        int i=0;int sum=0;
        while(i<s.length()){
            char singlechar=s.charAt(i);//get single char
            String currentsymbol=String.valueOf(singlechar);//convert char to string
            int currentvalue=map.get(currentsymbol);//retrieve the current value of that key/symbol
            int nextvalue=0;
            if(i+1<s.length()){
                char nextchar=s.charAt(i+1);
            String nextsymbol=String.valueOf(nextchar);
                nextvalue=map.get(nextsymbol);
            }
            if(currentvalue<nextvalue){
                sum=sum+(nextvalue-currentvalue);
                i=i+2;
            }
            else{
               sum=sum+currentvalue; 
                i=i+1;
            }
        }    
            
        return sum;
    }
}