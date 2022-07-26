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
    class Pair {
    int num; // horizontal distance
    TreeNode root;

    public Pair(int num, TreeNode root) {
        this.num = num;
        this.root = root;
    }
}
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().num;
            int first=0;
            int last =0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().num-min;
                TreeNode node = q.peek().root;
                q.poll();
                if (i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(node.left!=null){
                    q.offer(new Pair(cur_id*2+1,node.left));
                }
                if(node.right!=null){
                    q.offer(new Pair(cur_id*2+2,node.right));
                } 
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}