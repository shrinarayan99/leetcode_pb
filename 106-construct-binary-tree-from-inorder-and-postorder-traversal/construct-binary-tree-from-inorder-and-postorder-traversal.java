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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return sol(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode sol(int[] inorder, int[] postorder,int in_start,int in_end,int post_start,int post_end){
        if(in_start>in_end || post_start>post_end){
            return null;
        }
        TreeNode root=new TreeNode(postorder[post_end]);
        int idx=-1;
        for(int i=in_start;i<=in_end;i++){
            if(inorder[i]==postorder[post_end]){
                idx=i;
                break;
            }
        }
        
        int remain_left=idx-in_start;
        int remain_right=in_end-idx;

        root.left=sol(inorder,postorder,in_start,idx-1,post_start,post_start+remain_left-1);
        root.right=sol(inorder,postorder,idx+1,in_end,post_end-remain_right,post_end-1);
        return root;
    }
}