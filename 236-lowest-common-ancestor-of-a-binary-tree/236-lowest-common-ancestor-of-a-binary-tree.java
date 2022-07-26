/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
       if(root==null || root==p|| root==q){
           return root;
       }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);//traversing left
        TreeNode right = lowestCommonAncestor(root.right,p,q);//traversing right

        if(left==null){ // if left is null then return right
        return right;
        }
        else if(right==null){ // if right is null then return left
            return left;
        }
        else{ // return root if both found as LCA
            return root;
        }
    }
}