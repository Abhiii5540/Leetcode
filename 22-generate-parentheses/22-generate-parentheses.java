class Solution {
    public List<String> generateParenthesis(int n) {
        int closing=0;
        int opening=0;
        List<String> ans=new ArrayList<>();
        generateParenthesisHelper(n ,opening , closing , ans , "");
        return ans;
    }
    
    private static void  generateParenthesisHelper (int n ,int opening , int closing ,  List<String> ans , String brackets){
        // Termination case
        // as for n , N*2 brackets can be present as 3 open n 3 closed
        if(brackets.length()==n*2){
            ans.add(brackets);
            return;
        }
        // Number of opening brackets should be less than n , so that we can add the opening in the ans
        if(opening <n){
            generateParenthesisHelper(n ,opening+1 , closing , ans , brackets+"(");
  
        }
        // Number of closing brackets should be less than opening foradding closing brackets in the ans.
        if(closing<opening){
             generateParenthesisHelper(n ,opening , closing+1 , ans , brackets+")");


        }
    }
}