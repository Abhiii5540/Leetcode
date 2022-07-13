class Solution {
    public int majorityElement(int[] a) {
        int count=0;
        int majorityElement=0;
        int majCount=a.length/2;

        for (int i = 0; i < a.length; i++) {
            if(count==0){
                majorityElement=a[i];
            }
            if(a[i]==majorityElement){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for (int i : a) {
            if(i==majorityElement){
                count++;
            }
        }
        int ans=count>majCount?majorityElement:-1;
        return ans;
    }
}