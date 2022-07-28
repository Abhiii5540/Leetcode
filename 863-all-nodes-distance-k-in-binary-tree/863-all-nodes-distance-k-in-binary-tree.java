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
    
    private void mapParents(TreeNode root ,Map<TreeNode , TreeNode> parent_track ,TreeNode target){
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left!=null){
                parent_track.put(cur.left,cur);
                q.offer(cur.left);
            }
            
            if(cur.right!=null){
                parent_track.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent_track=new HashMap<>();
        mapParents(root,parent_track,target);
        Map<TreeNode , Boolean> visited =new HashMap<>();
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k){
                break;
            }
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }

                 if(cur.right!=null && visited.get(cur.right)==null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                
                 if(parent_track.get(cur)!=null&&visited.get(parent_track.get(cur))==null){
                     q.offer(parent_track.get(cur));
                    visited.put(parent_track.get(cur),true);
                 }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
             TreeNode cur = q.poll();
            result.add(cur.val);
        }
        return result;
    }
}