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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag=true; // true means left to right and false vice versa
            
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null){
                   q.offer(temp.left);
                }
                if(temp.right!=null){
                   q.offer(temp.right);
                }
                if(flag==true)
                    l.add(temp.val);

                else
                    l.add(0,temp.val);

            }
        flag=!flag;
            result.add(l);
        }
    return result;
    }
}