class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // Approach 1.brute force O(N^2)
//         int n=heights.length;
//         int maxArea=0;
//         for(int i=0;i<n;i++){
//             int left=i;
//             int right=i;
            
//             while(heights[left]>=heights[i]){
//                 left=left-1;
//             }
//             while(heights[right]>=heights[i]){
//                 right=right+1;
//             }
            
//             int width=(right-left+1);
//             // height=current element jiske liye check krree
            
//             maxArea=width*heights[i];
//         }
//         return maxArea;
        
        // Approach-2: using stack-conceots of next and prev smaller
        
        int maxArea=0;
        int n=heights.length;

        int prev[]=prevSmaller(heights);
        int next[]=nextSmaller(heights);
        
        for(int i=0;i<n;i++){
            int area=((next[i]-prev[i]-1)*heights[i]);
            maxArea=Math.max(maxArea,area);
        }
    return maxArea;
    }
    
    public int[] prevSmaller(int a[]){
        int n=a.length;
        int ans[]=new int[n];
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<=a.length-1;i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }
            else{
               ans[i]= s.peek();
            }
            s.push(i);
        }
        return ans;
    }
    
    public int[] nextSmaller(int a[]){
       int n=a.length;
       int ans[]=new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()]>=a[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i]=n;
            } else {
                ans[i]=s.peek();
            }
            s.push(i);
        }
        return ans;
    }
    
}