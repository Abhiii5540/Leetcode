/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> l = new LinkedList<List<Integer>>();
        // Root Node Goes in a Queue
        // Step-1 Create a Queue
        if (root == null)
            return l;

        queue.offer(root);
        // Step-2 Traverse Queue till it is not empty
        // 2.1 Queue poll and get the node and then look for Left and Right Child
        // 2.2 Add them in a Queue
        // and then Do Repeat the Step No -2.
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {

                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);

                sublist.add(queue.poll().val);
            }
            l.add(sublist);
        }
        return l;
    }
}