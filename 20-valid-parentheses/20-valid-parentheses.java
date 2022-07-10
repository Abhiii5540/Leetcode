class Solution {
    public boolean isValid(String s) {
        HashMap <Character , Character> m=new HashMap <>();
        m.put(')','(');
        m.put('}','{');
        m.put(']','[');
        
        Stack <Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            
            // if it is closing bracket pop it and return false if does not match with the key,s value put in hashmap
            
            if(m.containsKey(x)){
                if(stack.empty()){
                    return false;
                }
                else{
                    char top=stack.pop();
                    if(top!=m.get(x)){
                        return false;
                    }
                }
            }
            
            // if it is opening bracket push it
            else{
                stack.push(x);
            }
        }
        return stack.isEmpty();
    }
}