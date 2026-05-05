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
    public void flatten(TreeNode root) {
        if(root==null) return;

        flatten(root.left);
        flatten(root.right);
        TreeNode Right=root.right;
        TreeNode Left=root.left;

        root.right=root.left;
        root.left=null;
        TreeNode pointer=root;
        while(pointer.right!=null){
            pointer=pointer.right;
        }
        pointer.right=Right;

        
    }
}