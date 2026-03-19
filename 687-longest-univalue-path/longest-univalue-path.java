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
    public static int ans;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        ans=0;
        int p=find_Path_length(root);
        return ans;
    }
    public int find_Path_length(TreeNode root){
        if(root==null) return 0;
        int left=find_Path_length(root.left);
        int left_length=0;
        if(root.left!=null && root.val==root.left.val){
            left_length=left+1;
        }
        int right=find_Path_length(root.right);
        int right_length=0;
        if(root.right!=null && root.val==root.right.val){
           right_length=right+1;
        }
        ans=Math.max(ans,right_length+left_length);
        
        return Math.max(right_length,left_length);
    }
}