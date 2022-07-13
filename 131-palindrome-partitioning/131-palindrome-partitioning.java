class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
    List<String> ds=new ArrayList<>();
        solve(s,0,ans,ds);
        return ans;
    }
    public  void solve(String s , int index , List<List<String>> ans, List<String> ds)
    {
        //base condition
        if(index==s.length()){
           ans.add(new ArrayList<>(ds));
            return ;
        }
        
        for(int i=index;i<s.length();i++){//op to iterate and find a partition
            if(isPalinDrome(s,index,i)){ 
            // if palindrome then partition it by taking substring from index to i+1 and add to the ans and do backtracking it by removing the top element
                ds.add(s.substring(index , i+1));
                solve(s,i+1,ans,ds);
                ds.remove(ds.size()-1);
            }
            
        }
    }
    public boolean isPalinDrome(String s , int index , int i){
        // checking for palindrome
        while(index<=i){
            if(s.charAt(index++)!=s.charAt(i--)){
                return false;
            }
        }
        return true;
    }
}