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
    
    private int helperForMaxSumPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=helperForMaxSumPath(root.left);
        int rh=helperForMaxSumPath(root.right);
        
        lh=lh>0?lh:0;
        rh=rh>0?rh:0;
        
        maxi=Math.max(maxi,root.val+lh+rh);
        
        return root.val+Math.max(lh,rh);
    }
    
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helperForMaxSumPath(root);
        return maxi;
    }
}