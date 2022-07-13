class Solution {
    public int findPeakElement(int[] arr) {
        
          int peakElement = 0;
        int n=arr.length;
          if (n == 1) {
         return 0;
          }
          for (int i = 0; i < n; i++) {
          if (i == 0) {// start index
          if (arr[i] > arr[i+1]) {
          peakElement = i;
          }
          } else if (i == n - 1) {// last index
          if (arr[i - 1] < arr[i]) {
          peakElement = i;
          }
          } else {//neighbour element
          if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
          peakElement = i;
          }
          }
          }
         return peakElement;
         
    }
}