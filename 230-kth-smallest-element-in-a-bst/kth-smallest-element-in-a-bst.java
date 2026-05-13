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
    public static int count;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        return sol(root,k);
    }
    public int sol(TreeNode root, int k){
        if(root==null) return 0;
        int left=sol(root.left,k);
        count++;
        if(count==k) return root.val;
        int right=sol(root.right,k);

        return Math.max(left,right);
    }
}