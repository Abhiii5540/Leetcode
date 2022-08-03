/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();
    // false means we are calling next()
    // true means we are calling before()
    private boolean reverse=false;

    public BSTIterator(TreeNode root , boolean reverse) {
        this.reverse=reverse;
        pushAll(root);
    }
    
     /** @return the next smallest number */
    public int next() {
        TreeNode temp = s.pop();
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }
    
     /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    public void pushAll(TreeNode root) {
        while(root!=null){
            s.push(root);
            if(reverse==true)
                root=root.right;
            else
                root=root.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        BSTIterator obj=new BSTIterator(root,false);//next()
        BSTIterator obj2=new BSTIterator(root,true);//before()
        
        int i=obj.next();
        int j=obj2.next();
        
        while(i<j){
            int sum=i+j;
            if(sum==k){
                return true;
            }
            else if(sum<k){
                i=obj.next();//calling for next element from the next function for true , i.e. moving the i pointer to i+1;
            }
            else{
                j=obj2.next();//calling for next element from the next function but for false this time , i.e. moving the j pointer to j+1;
            }
        }
        return false;
    }
}