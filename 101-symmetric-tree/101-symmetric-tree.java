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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left , root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left , TreeNode right){
        if(left==null || right==null){
            return left == right; // returns true if left and right values are same
        }
        if(left.val!=right.val){
            return false;
        }
        //we go root-left-right on left subtreee and root-right-left on right subtree and match each values.
        return isSymmetricHelper(left.left , right.right) && isSymmetricHelper(left.right , right.left); // returns true if left subtree and right subtree returns true 
        
    }
}