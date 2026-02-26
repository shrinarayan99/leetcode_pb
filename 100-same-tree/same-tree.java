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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(p);
        Queue<TreeNode> q2=new LinkedList<>();
        q2.add(q);

        while(!q1.isEmpty()){
            int size=q1.size();
            for(int i=0;i<size;i++){
                TreeNode curr_p=q1.poll();
                TreeNode curr_q=q2.poll();
                if(curr_p==null && curr_q==null) continue;
                if(curr_p==null || curr_q==null) return false;
                if(curr_p.val!=curr_q.val) return false;
                
        
                    q1.add(curr_p.left);
                
                
                    q2.add(curr_q.left);
                
                
                    q1.add(curr_p.right);
              
                    q2.add(curr_q.right);
                
            }
        }
        return true;
    }
}