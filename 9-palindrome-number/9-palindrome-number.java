class Solution {
    public boolean isPalindrome(int x) {
        int d=0;
        for(int i=x;i>0;i=i/10)
        {
            int r=i%10;
            d=(d*10)+r;
        }
        if (x==d){
            return true;
        }else
            return false;
    }
}