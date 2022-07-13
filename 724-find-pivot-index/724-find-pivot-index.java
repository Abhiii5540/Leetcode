class Solution {
    public int pivotIndex(int[] a) {
           if(a.length==1){
            return 0;
        }
        int sum=0 , leftSum=0;
        for (int i = 0; i < a.length; i++) {
            sum=sum+a[i];
        }

        for (int i = 0; i < a.length; i++) {
            sum=sum-a[i];
            if(sum==leftSum)
            return i;
            
            leftSum = leftSum + a[i];
        }
        return -1;
    }
}