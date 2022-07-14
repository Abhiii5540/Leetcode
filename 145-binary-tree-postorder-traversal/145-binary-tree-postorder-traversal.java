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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        List<Integer> l =new ArrayList<Integer>();
        if(root==null){
            return l;
        }
        s1.push(root);
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }        
        while(!s2.isEmpty()){
            root=s2.pop();
            l.add(root.val);
        }
    return l;
    }
}