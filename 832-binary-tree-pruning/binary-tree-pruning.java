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
    public TreeNode pruneTree(TreeNode root) {
        boolean roo=sol(root);
        if(!roo) return null;
        return root;
    }
    public boolean sol(TreeNode root){
        if(root==null) return false;

        boolean left=sol(root.left);
        boolean right=sol(root.right);

        boolean current=false;
        if(root.val==1){
            current=true;
        }
        if(left==false){
            root.left=null;
        }
        if(right==false){
            root.right=null;
        }

        return current||(left||right);
    }
}