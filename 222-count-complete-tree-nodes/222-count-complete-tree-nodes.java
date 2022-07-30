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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=leftTreeHeight(root);
        int rightHeight=rightTreeHeight(root);
        
        if(leftHeight==rightHeight){//If left and right are equal it means that the tree is complete and hence go for 2^h -1.
            return ((2<<(leftHeight))-1);
        }
        else{ //else recursively calculate the number of nodes in left and right and add 1 for root.
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
    
    private int leftTreeHeight(TreeNode root){
        int c=0;
        while(root.left!=null){
            c++;
            root=root.left;
        }
        return c;
    }
    
    public int rightTreeHeight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
}