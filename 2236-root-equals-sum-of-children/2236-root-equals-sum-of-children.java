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
    public boolean checkTree(TreeNode root) {
        if(root==null) return false;
        int carry=0;
        if(root.left!=null)
            carry+=root.left.val;
        if(root.right!=null)
            carry+=root.right.val;
        
        if(carry==root.val) return true;
        else return false;
    }
}