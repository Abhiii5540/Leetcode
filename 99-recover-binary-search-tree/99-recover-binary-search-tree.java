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
class Solution {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    
    private void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val){//if prev value is greater than current root value then it is violation. 
            
             // If this is first violation, mark these two nodes as
            // 'first' and 'middle'
            if(first==null){
                first=prev;
                middle=root;
            }
             // If this is second violation,means two nodes adjacent are not wrong ,mark these two nodes as'first' and 'last'
            else{
                last=root;
            }
        }
          prev=root; // after every check mark prev to root
          inorder(root.right);

    }

    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){ // no adjacent nodes
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if(first!=null && middle!=null){ // adjacent nodes
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }
}