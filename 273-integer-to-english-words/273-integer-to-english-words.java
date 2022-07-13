class Solution {
    HashMap <Integer,String> constant;
    int range[]=new int[]{1000000000,1000000,1000,100};
        String words[]=new String[]{"Billion","Million","Thousand","Hundred"};
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        constant = new HashMap<>();
        fillConstant();
        return numToWords(num);
    }
    public String numToWords(int num) {
        if(constant.containsKey(num))
            return constant.get(num);
        
        StringBuilder sb=new StringBuilder();
        if(num<100){
        sb.append(numToWords(num/10*10));
        sb.append(" ");
        sb.append(numToWords(num%10));
        }
        else{
            for(int i=0;i<4;i++){
                if(num<range[i])
                    continue;
            sb.append(numToWords(num/range[i]));
            sb.append(" ");
            sb.append(words[i]);
            sb.append(" ");
        sb.append(numToWords(num%range[i]));
                break;
                
            }
        }
          return sb.toString().trim();  
    }
    public void fillConstant(){
constant.put(0,"");
constant.put(1,"One");
constant.put (2,"Two");
constant.put(3,"Three");
constant.put(4,"Four");
constant.put (5,"Five");
constant.put (6,"Six");
constant.put(7,"Seven");
constant.put(8,"Eight");
constant.put (9,"Nine");
constant.put(10,"Ten");
constant.put(11,"Eleven");
constant.put(12,"Twelve");
constant.put(13,"Thirteen");
constant.put (14,"Fourteen");
constant.put(15,"Fifteen");
constant.put(16,"Sixteen");
constant.put(17,"Seventeen");
constant.put (18,"Eighteen");
constant.put(19,"Nineteen");
constant.put(20,"Twenty");
constant.put(30,"Thirty");
constant.put (40,"Forty");
constant.put(50,"Fifty");        
constant.put(60,"Sixty");
constant.put(70,"Seventy");
constant.put (80,"Eighty");
constant.put (90,"Ninety");
    }
}