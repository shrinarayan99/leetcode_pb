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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        TreeNode mirrored=mirror(root);
       
        
        return check(root,mirrored);
    }
    public TreeNode mirror(TreeNode root){
        if(root==null) return null;

        TreeNode newNode=new TreeNode(root.val);
        newNode.right=mirror(root.left);
        newNode.left=mirror(root.right);
        return newNode;
    }

    public boolean check(TreeNode root,TreeNode newNode){
        if(root == null && newNode == null) return true;
        if(root == null || newNode == null) return false;
        if(root.val!=newNode.val) return false;

        if(check(root.right,newNode.right) && check(root.left,newNode.left)){
            return true;
        }
        return false;
    }
}