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
     TreeNode prev=null;
    public void flatten(TreeNode root) {
        
        // 1. Iterative way
        //  if (root == null) return;
        // Stack<TreeNode> s = new Stack<>();
        // s.push(root);
        // while(!s.isEmpty()){
        //     TreeNode cur = s.peek();
        //     s.pop();
        //     if(cur.right!=null){
        //         s.push(cur.right);
        //     }
        //     if(cur.left!=null){
        //         s.push(cur.left);
        //     }
        //     if(!s.isEmpty()){
        //         cur.right=s.peek();
        //     }
        //     cur.left=null;
        // } 
        
        // 2. Recursive way
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        
        root.right=prev;
        root.left=null;
        prev=root;

    }
}