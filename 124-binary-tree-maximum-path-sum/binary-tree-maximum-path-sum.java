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
    public static int res;
    public int maxPathSum(TreeNode root) {
        res=Integer.MIN_VALUE;
        sol(root);
        return res;
    }
    public int sol(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=sol(root.left);
        int right=sol(root.right);

        int opr1=Math.max(left,right)+root.val;
        int opr2=left+right+root.val;
        int opr3=root.val;

        res=Math.max(res,Math.max(opr1,Math.max(opr2,opr3)));

        return Math.max(opr1,opr3);
    }
}