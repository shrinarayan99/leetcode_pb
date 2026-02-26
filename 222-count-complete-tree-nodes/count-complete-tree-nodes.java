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
         if (root == null) return 0;
        // nodes can we repeated
        //HashSet<Integer> set=new HashSet<>();

        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            // if(curr!=null){
            //     set.add(curr.val);
            // }
            count++;
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        // return set.size();
        return count;
    }
}