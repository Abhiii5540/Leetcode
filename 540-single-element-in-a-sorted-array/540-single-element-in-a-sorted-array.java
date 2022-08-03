class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int ans=0;
        int i=0;
        while(i<n-1){
            if(nums[i]==nums[i+1]){
                i=i+2;
                // continue;
            }
            else{
                ans=nums[i];
                return ans;
            }
        }
        ans=nums[n-1];
        return ans;
    }
}