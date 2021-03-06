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


/*
class solutionToLeftView{

// DFS solution
     void printLeftViewRecursive(BinaryTree<Integer> root, int level) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(root.data);
            System.out.println(ans);
        }
        printLeftViewRecursive(root.left, level + 1);
        printLeftViewRecursive(root.right, level + 1);
    }

// BFS solution
    void printLeftViewIterative(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                BinaryTree<Integer> node = queue.poll();
                if (i == 0) {
                    System.out.println(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

    }
}
*/


class Solution {
    
        // DFS solution
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         rightSideViewHelper(root , 0 , ans);
//         return ans;
//     }
    
//    public void rightSideViewHelper(TreeNode root , int level , List<Integer> ans){
//         if(root== null){
//             return;
//         }
//         if(ans.size()==level){
//             ans.add(root.val);
//         }
//         rightSideViewHelper(root.right , level+1 , ans);
//         rightSideViewHelper(root.left , level+1 , ans);   
//     }
    
    
    // BFS solution 
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideViewHelper(root , 0 , ans);
        return ans;
    }
    
    public void rightSideViewHelper(TreeNode root , int level , List<Integer> ans){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
    }
}