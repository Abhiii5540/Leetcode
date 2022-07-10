class Solution {
    public List<String> generateParenthesis(int n) {
        int closing=0;
        int opening=0;
        List<String> ans=new ArrayList<>();
        generateParenthesisLogic(n ,opening , closing , ans , "");
        return ans;
    }
    
    private static void  generateParenthesisLogic (int n ,int opening , int closing ,  List<String> ans , String brackets){
        // Termination case
        // as for n , N*2 brackets can be present as 3 open n 3 closed
        if(brackets.length()==n*2){
            ans.add(brackets);
            return;
        }
        // Number of opening brackets should be less than n
        if(opening <n){
            generateParenthesisLogic(n ,opening+1 , closing , ans , brackets+"(");
  
        }
        // Number of closing brackets should be less than opening
        if(closing<opening){
             generateParenthesisLogic(n ,opening , closing+1 , ans , brackets+")");


        }
    }
}