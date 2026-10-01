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
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        int right=traverseRight(root.right);
        int left=traverseLeft(root.left);
        int value=root.val;

        if(left>right){
            replaceRight(root.right,left,right);
            replaceLeft(root.left,right,left);
        }
       
       else if(value<left){
            root.val=left;
            replaceLeft(root.left,value,left);
        }
       else if(value>right){
            root.val=right;
            replaceRight(root.right,value,right);
        }
        recoverTree(root.right);
        recoverTree(root.left);
        
        
    }
    public int traverseRight(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(traverseRight(root.right),traverseRight(root.left)));
    }
    public int traverseLeft(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(traverseLeft(root.left),traverseLeft(root.right)));
    }
    public void replaceRight(TreeNode root,int value,int replace){
        if(root==null) return;
        if(root.val==replace){
            root.val=value;
        }
        replaceRight(root.right,value,replace);
        replaceRight(root.left,value,replace);
    }
    public void replaceLeft(TreeNode root,int value,int replace){
        if(root==null) return;
        if(root.val==replace){
            root.val=value;
        }
        replaceLeft(root.left,value,replace);
        replaceLeft(root.right,value,replace);
    }
}