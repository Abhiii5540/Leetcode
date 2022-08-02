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
    int c=0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
         if(root.left!=null) {
             kthSmallest(root.left,k);
         }
        c+=1; //keeps the count of nodes added in inorder traversal
        
        if(k==c) //if count is equal to required k, set ans
        {
            ans=root.val;
            return ans;
        }
        if(root.right!=null) {
            kthSmallest(root.right,k);
        }
        return ans;
    }
}