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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null) return null;

        return CommonAncestor(root,p,q);
    }
    public TreeNode CommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        if(root==null) return root;
        TreeNode left=CommonAncestor(root.left,p,q);
        TreeNode right=CommonAncestor(root.right,p,q);

        if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        if(left!=null && right!=null) return root;
        return null;
    }
}