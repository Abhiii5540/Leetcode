class Solution {
    public int[] smallerNumbersThanCurrent(int[] a) {
        
         int n = a.length;
        int ans[]=new int[n];
        int temp[]=new int [101];
        // frequency is stored
        for (int i = 0; i < n; i++) {
            temp[a[i]]++;
        }
        // runnning sum
        for (int i = 1; i <101; i++) {
            temp[i]=temp[i]+temp[i-1];
        }
        // storing the result
        for (int i = 0; i < n; i++) {
            if(a[i]==0)
                ans[i]=0;
            else{
                ans[i]=temp[a[i]-1];
            }
        }
        
        // int n = a.length;
        // int[] ans = new int[n];
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (a[i] > a[j] && i != j) {
        //             count++;
        //         }
        //     }
        //     ans[i] = count;
        // }
        return ans;
    }
}